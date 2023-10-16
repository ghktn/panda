/**
 * 기능 : Toast UI 게시판 생성
 */
const editor = new toastui.Editor({
  el: document.querySelector("#toastUiBoard"), // 에디터를 적용할 요소 (컨테이너)
  height: "500px", // 에디터 영역의 높이 값 (OOOpx || auto)
  initialEditType: "wysiwyg", // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
  initialValue: "나의 수업을 소개해주세요.", // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
  previewStyle: "vertical", // 마크다운 프리뷰 스타일 (tab || vertical)
  
  /* start of hooks */
	hooks: {
	    async addImageBlobHook(blob, callback) { // 이미지 업로드 로직 커스텀
	        try {
	            /*
	             * 1. 에디터에 업로드한 이미지를 FormData 객체에 저장
	             *    (이때, 컨트롤러 uploadEditorImage 메서드의 파라미터인 'image'와 formData에 append 하는 key('image')값은 동일해야 함)
	             */
	            const formData = new FormData();
	            formData.append('image', blob);
	
	            // 2. FileApiController - uploadEditorImage 메서드 호출
	            const response = await fetch('/tui-editor/image-upload', {
	                method : 'POST',
	                body : formData,
	            });
	
	            // 3. 컨트롤러에서 전달받은 디스크에 저장된 파일명
	            const filename = await response.text();
	            console.log('서버에 저장된 파일명 : ', filename);
	
	            // 4. addImageBlobHook의 callback 함수를 통해, 디스크에 저장된 이미지를 에디터에 렌더링
	            const imageUrl = `/tui-editor/image-print?filename=${filename}`;
	            callback(imageUrl, 'image alt attribute');
	
	        } catch (error) {
	            console.error('업로드 실패 : ', error);
	        }
	    }
	}
  /* end of hooks */  
  
  
});

// 변수

const myClassCallBtn = document.querySelector("#myClassCallBtn"); // 나의 수업 불러오기 버튼
const modalBody = document.querySelectorAll(".modal-body")[0]; // 나의 수업 목록 body
const myModal = document.querySelector("#myModal"); // 모달창
const interestHeart = document.querySelector("#interestHeart"); // 관심 하트 모양
const myClassChoiceBox = document.querySelectorAll(".myClassChoiceBox")[0]; // 내가 불러온 수업

// 공고 컨텐츠 불러오기
const maxStdCount = document.querySelector("#maxStdCount");
const stdGender = document.querySelector("#stdGender");
const stdAgeGroup = document.querySelector("#stdAgeGroup");
// const wishStudyCount = document.querySelector("#wishStudyCount");
const wishDays = document.querySelectorAll(".wishDays");
const lectureType = document.querySelector("#lectureType");

// 수업 리스트 - 예시
let myClassList = [
  { number: 0, title: "수학 배우기......" },
  { number: 1, title: "과학 배우기......" },
  { number: 2, title: "영어 배우기......" },
  { number: 3, title: "일본어 배우기......" },
  { number: 4, title: "중국어 배우기......" },
  { number: 5, title: "물리 배우기......" },
  { number: 6, title: "화학 배우기......" },
  { number: 7, title: "체육 배우기......" },
  { number: 8, title: "영어2 배우기......" },
  { number: 9, title: "한글 배우기......" },
  { number: 10, title: "국어 배우기......" },
  { number: 11, title: "미술 배우기......" },
  { number: 12, title: "수영 배우기......" },
  { number: 13, title: "피아노 배우기......" },
  { number: 14, title: "댄스 배우기......" },
];

/**
 * 모달창이 닫히면 입력될 데이터
 * 나중에는 수업 id로 데이터 불러와서 사용한다. - 완료(10.16)
 * // 모집공고 데이터를 위해 필요하다.
 */
let values = {
  maxStdCount: 2,
  stdGender: "M",
  stdAgeGroup: 3,
  wishStudyCount: 4,
  wishDays: [3, 1],
  lectureType: 0,
};

let interestHeartStatus = false; // 관심 하트 모양 상태

/**
 * 기능 : 관심 하트 클릭하면 색깔이 바뀐다.
 */
// const handleInterestHeartClick = function () {
//   interestHeart.addEventListener("click", () => {
//     if (interestHeartStatus === false) {
//       interestHeart.innerHTML = "❤️";
//       interestHeartStatus = true;
//     } else {
//       interestHeart.innerHTML = "🤍";
//       interestHeartStatus = false;
//     }
//   });
// };

/**
 * 기능 : TODO : 수업 불러오기(2023.10.16 ~ )
 */
const getClassListByUserId = async () => {
	
	const userId = 1;
	const url = `http://localhost:9010/classtests/${userId}`;
	const classList = await fetch(url, {
		method: 'get',
	});
	
//	console.log(classList.json());
	return classList.json();
}

/**
 * 기능 : 수업 목록을 보여준다.
 * param : bound - 페이자 당 보여지는 개수
 */
const showMyClassList = function (bound) {
  // ul element 만들기
  const ul = document.createElement("ul");
  // li element 만들기
  const topLi = document.createElement("li");
  topLi.innerHTML = `<div class="row">
                      <div class="col-sm-2">번호</div>
                      <div class="col-sm-10">제목</div>
                    </div>`;
  ul.appendChild(topLi);

  myClassList.forEach((myClass, index) => {
    const li = document.createElement("li");
    li.innerHTML = `<div class="row">
                      <div class="col-sm-2">${index + 1}</div>
                      <div class="col-sm-10">${myClass.title}</div>
                    </div>`;

    // li.innerHTML = `${index + 1}, ${myClass.title}`;
    // ul에 추가하기
    ul.appendChild(li);

    // li click 이벤트
    li.addEventListener("click", () => {
      // modal 창이 꺼진다.
      $("#myModal").modal("hide");
      // 공고에 데이터가 입력된다.
      const classValues = myClassList[index];
      values = classValues;// 모집공고 데이터를 위해 필요하다.
      console.log(values);

      maxStdCount.value = classValues.max_std_count;
      stdGender.value = classValues.std_gender;
      stdAgeGroup.value = classValues.std_age_group;
      // wishStudyCount.value = values.wishStudyCount;
      // 수업희망요일 불러오기
      // 배열로 만들기
      const wishDaysArr = classValues.wish_days.split(",");
//      console.log(wishDaysArr);
      wishDays.forEach((wishDay, index) => {
		// 초기화
		wishDay.checked = false;
        wishDaysArr.forEach((wishDayValue, index2) => {
          if (wishDay.value === wishDayValue) {
            wishDay.checked = true;
          }
        });
      });
      lectureType.value = classValues.lecture_type;
      // 내가 불러온 수업 추가
      myClassChoiceBox.innerHTML = `<div>수업 : ${myClass.title}</div>`;
    });
  });
  // 모달창에 추가하기
  modalBody.appendChild(ul);
};

/**
 * 기능 : 모달창 열기
 */
const openModal = function () {
  $(document).ready(function () {
    $("#myClassCallBtn").click(function () {
      $("#myModal").modal();
    });
  });
};

/**
 * 기능 : 실행함수
 */
const start = async function () {

  // ****** 10.16 ******
  // classList 불러오기
  try {
  	myClassList = await getClassListByUserId();
//  	console.log(myClassList);
  } catch(error) {
	console.log(error);
  }	
	
  // 나의 수업 확인하기 보여주기
  showMyClassList();
  // 관심 하트 모양 바꾸기 - 현재 사용 안함(2023.09.15~)
  // handleInterestHeartClick();
  // 모달창 열기
  openModal();

};

start();

/**
 * 기능 : 저장을 요청할 수 있습니다.
 */
const requestSave = async (data) => {
	
	// DB에 저장 요청하기
	const url = "http://localhost:9010/recruitments";// 확인 ok
	const result = await fetch(url, {
		method: "post",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(data)
	});
	return result.json();
}


/**
 * 기능 : 모집 공고 저장하기
 */
const handleSavingClick = async () => {
	
	const title = document.querySelector("#title");
	const contents = editor.getHTML();
//	console.log(contents);
	const wishPay = document.querySelector("#wishPay");
	
	// 저장할 데이터
	const data = {
		id: values.class_reg_user_id,// 작성자 id
		recruitment_board_id: "TS",// TODO : 임의로 정함 html에 추가해야 한다.
		class_id: values.class_id,
		title: title.value,
		contents: contents,
		wish_pay: wishPay.value,// TODO : 작성할 수 있도록 만들어야 한다. html에
	}
	
//	console.log(data);// 확인 ok
	
	// DB에 저장 요청하기
	try {
		const result = await requestSave(data);
		
		console.log(result);
		console.log(typeof result);
		
		// 성공하면 list로 간다.	
		if(result === 1) {
			location.href = "http://localhost:9010/recruitment";
		}
	} catch(error) {
		console.log(error);
	}
}
















