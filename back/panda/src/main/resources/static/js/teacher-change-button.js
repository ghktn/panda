/**
 * 기능 : 선생님, 학생 상태로 전환 기능입니다.
 */
$(document).ready(() => {
  let changeSignal = false; // 바뀜상태

  $(".btn.change").click(() => {
    if (changeSignal) {
      $(".btn.change").html("선생님으로 전환하기");
      changeSignal = false;
    } else {
      $(".btn.change").html("학생으로 전환하기");
      changeSignal = true;
    }
  });
});
