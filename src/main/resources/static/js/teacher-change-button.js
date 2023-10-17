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
/*
기능 : 분야 선택 기능
*/
$(document).ready(function() {
	$("#categoryMainId").on("change", function() {
		const categoryMainId = $("#categoryMainId").val();
		var queryData = { "category_main_id": $("#categoryMainId").val() }

		const categorySubId = $("#categorySubId");
		if (!categoryMainId) {
			categorySubId.html("<option value=''>선택</option>");
			return;
		}

		$.ajax({
			url: "/cate-sub",
			type: "get",
			data: queryData,
			success: success_run,
			error: error_run
		})
	})
});

function success_run(resultData) {

	let result = "";
	result += "<option>선택</option>"
	resultData.forEach(function(data) {
		result += "<option value=" + data.category_sub_id + ">" + data.category_sub_name + "</option>"

	});
	$("#categorySubId").html(result);
}

function error_run(obj, resMsg, errorMsg) {
	console.log("error");
	console.log(obj);
	console.log(resMsg);
	console.log(errorMsg);
}