

$("#mytabs>ul>li>a").each(function (i) {
  $(this).attr("href", "#mytab" + i);
});
$("#mytabs>div>div").each(function (i) {
  $(this).attr("id", "mytab" + i);
});

/**
 * 기능 : 수업신청 modal 기능입니다.
 */



