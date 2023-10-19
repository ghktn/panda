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
const handleSavingClick = async () => {
	const class_id = document.querySelector("#class_id");
	const score = document.querySelector("#score");
	const contents = editor.getHTML();
//	console.log(contents);	
	// 저장할 데이터
	const data = {
		id: values.class_reg_user_id,// 작성자 id
		class_id: values.class_id,
		contents: contents,
		score: values.score// TODO : 작성할 수 있도록 만들어야 한다. html에
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