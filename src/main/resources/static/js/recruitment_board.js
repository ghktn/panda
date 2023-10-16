/**
 * 기능 : Toast UI 게시판 생성
 */
const editor = new toastui.Editor({
  el: document.querySelector("#toastUiBoard"), // 에디터를 적용할 요소 (컨테이너)
  height: "500px", // 에디터 영역의 높이 값 (OOOpx || auto)
  initialEditType: "wysiwyg", // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
  initialValue: "나의 수업을 소개해주세요.", // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
  previewStyle: "vertical", // 마크다운 프리뷰 스타일 (tab || vertical)
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
const myClassList = [
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
 * 나중에는 수업 id로 데이터 불러와서 사용한다.
 */
const values = {
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
      maxStdCount.value = values.maxStdCount;
      stdGender.value = values.stdGender;
      stdAgeGroup.value = values.stdAgeGroup;
      // wishStudyCount.value = values.wishStudyCount;
      // 수업희망요일 불러오기
      wishDays.forEach((wishDay, index) => {
        values.wishDays.forEach((wishDayValue, index2) => {
          if (Number(wishDay.value) === wishDayValue) {
            wishDay.checked = true;
          }
        });
      });
      lectureType.value = values.lectureType;
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
const start = function () {
  // 나의 수업 확인하기 보여주기
  showMyClassList();
  // 관심 하트 모양 바꾸기 - 현재 사용 안함(2023.09.15~)
  // handleInterestHeartClick();
  // 모달창 열기
  openModal();
};

start();
