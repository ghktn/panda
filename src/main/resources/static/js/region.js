/*
시군구 리스트
*/
$(document).ready(function() {
	$("#sdName").on("change", function() {
		const sdName = $("sdName").val();
		var queryData = { "sd_code": $("#sdName").val() }
		$("#emdName").html("<option value=''>선택</option>");
		$("#sggName").html("<option value=''>선택</option>");
		const sggName = $("#sggName");
		if (sdName) {
			sggName.html("<option value=''>선택</option>");
			emdName.html("<option value=''>선택</option>");
			return;
		}
		$.ajax({
			url: "/region_sgg",
			type: "get",
			data: queryData,
			success: success_sgg_run,
			error: error_run
		})
	})
});

function success_sgg_run(resultData) {
	console.log(resultData);
	let result = "";
	result += "<option value=''>선택</option>"
	resultData.forEach(function(data) {
		result += "<option value=" + data.sgg_code + ">" + data.sgg_name + "</option>"
	})
	$("#sggName").html(result);
}

function error_run(obj, resMsg, errorMsg) {
	console.log("error");
	console.log(obj);
	console.log(resMsg);
	console.log(errorMsg);
}

/*
읍면동 리스트
*/
$(document).ready(function() {
	$("#sggName").on("change", function() {
		var queryData = { "sgg_code": $("#sggName").val() }
		const sggName = $("sggName").val();
		console.log(sggName);	
		const emdName = $("#emdName");
		if (sggName) {
			emdName.html("<option value=''>선택</option>");
			return;
		}
		$.ajax({
			url: "/region_emd",
			type: "get",				
			data: queryData,
			success: success_emd_run,
			error: error_run
			})
	})
});

function success_emd_run(resultData) {
	console.log(resultData);
	let result = "";
	result += "<option value=''>선택</option>"
	resultData.forEach(function(data) {
		result += "<option value=" + data.emd_code + ">" + data.emd_name + "</option>"
	})
	$("#emdName").html(result);
}