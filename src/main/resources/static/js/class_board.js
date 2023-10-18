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
const requestSave = async (data) => {
	
	// DB에 저장 요청하기
	const url = "http://localhost:9010/register-class";// 확인 ok
	const result = await fetch(url, {
		method: "post",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(data)
	});
	return result.json();
}
const handleSavingClick = async () => {
	const title = document.querySelector("#title").value;
	const category_main_id = document.querySelector("#categoryMainId").value;
	const category_sub_id = document.querySelector("#categorySubId").value;
	const max_std_count = document.querySelector("#maxStdCount").value;
	const std_gender = document.querySelector("#stdGender").value;
	const std_age_group = document.querySelector("#stdAgeGroup").value;
	const pay = document.querySelector("#wishPay").value;
	const wish_study_count = document.querySelector("#wishStudyCount").value;
	const lecture_type = document.querySelector("#lectureType").value;
	const sd_code = document.querySelector("#sdName").value;
	const sgg_code = document.querySelector("#sggName").value;
	const emd_code = document.querySelector("#emdName").value;
	const wish_days = Array.from(document.querySelectorAll(".wishDays"));
	const cinfo = editor.getHTML();
	//wishDays만들기
	const wish_days_arr = wish_days.filter((wishday) =>{
		return wishday.checked == true;
	}).map((wishday) => {
		return wishday.value;
	});
	
	const wish_days_str =  wish_days_arr.join();
		
	
	const data = {
		title: title,
		category_main_id:category_main_id,
		category_sub_id:category_sub_id,
		max_std_count:max_std_count,
		std_gender:std_gender,
		std_age_group:std_age_group,
		pay:pay,
		wish_study_count:wish_study_count,
		lecture_type:lecture_type,
		sd_code:sd_code,
		sgg_code:sgg_code,
		emd_code:emd_code,
		wish_days:wish_days_str,
		cinfo: cinfo
	}
	
//	console.log(data);// 확인 ok
	
	// DB에 저장 요청하기
	try {
		const result = await requestSave(data);
		console.log(result);
		console.log(typeof result);
		
		// 성공하면 list로 간다.	
		if(result === 1) {
			location.href = "http://localhost:9010/myclass-list";
		}
	} catch(error) {
		console.log(error);
	}
}
