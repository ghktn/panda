

// 수업 이름 배치하기
$(document).ready(function () {
  // 닉네임
  $(".infoBox #nickname").html(teacherUser.name);
  // 제목
  $("#classTitle").html(teacherUser.classInfo.title);
  // 수업 카테고리
  $(".infoBox .classInfo .bigClassifation").html(
    teacherUser.classInfo.category.big
  );
  $(".infoBox .classInfo .smallClassifation").html(
    teacherUser.classInfo.category.small
  );

  // 수강비
  $(".infoBox .classPrice").html(teacherUser.classInfo.pay);
});

/**
 * 기능 : Toast UI 게시판 생성
 */
const editor = new toastui.Editor({
  el: document.querySelector("#toastUiBoard"), // 에디터를 적용할 요소 (컨테이너)
  height: "500px", // 에디터 영역의 높이 값 (OOOpx || auto)
  initialEditType: "wysiwyg", // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
  initialValue: "수업 후기를 적어주세요.", // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
  previewStyle: "vertical", // 마크다운 프리뷰 스타일 (tab || vertical)
});
