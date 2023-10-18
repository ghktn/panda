// 찜하기 버튼의 클릭 이벤트 처리
$(document).ready(function () {
  var liked = false; // 찜하기 상태 초기값 (찜하지 않음)

  $("#likeButton").click(function () {
    liked = !liked; // 상태 토글 (찜하기 누를 때마다 상태 변경)

  });
});

// if (liked) {
//   // 찜하기 상태일 때 아이콘과 텍스트 변경
//   $("#likeButton").html('<i class="fas fa-heart"></i> 관심수업등록완료');
//   $("#likeButton").removeClass("btn-danger").addClass("btn-success");
// } else {
//   // 찜하기 해제 상태일 때 아이콘과 텍스트 변경
//   $("#likeButton").html('<i class="fas fa-heart"></i> 관심수업등록');
//   $("#likeButton").removeClass("btn-success").addClass("btn-danger");
// }