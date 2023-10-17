//카테고리 소분류
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


// open 버튼 불러오기
const openBtns = document.querySelectorAll(".teacher_info_open");
// close 버튼 불러오기
const closeBtns = document.querySelectorAll(".teacher_info_close");
// 팝업창 선택하기
let targetId = "";

// open이벤트 만들기
openBtns.forEach((openBtn, index) => {
	openBtn.addEventListener("click", (event) => {
		// 팝업창 id 찾기
		targetId = event.target.parentElement.getAttribute("href");
		// 팝업창 열기
		const popInfo = document.querySelector(targetId);
		// 화면 보이기
		popInfo.style.display = "block";
		// 카테고리 대분류
		$.ajax({
			url: "/cate-main",
			type: "get",
			success: success_main_run,
			error: error_run
		})
	});
});
function success_main_run(resultData) {

	let result = "";
	result += "<option>선택</option>"
	resultData.forEach(function(data) {
		result += "<option value=" + data.category_main_id + ">" + data.category_main_name + "</option>"

	});
	$("#categoryMainId").html(result);
}

// close 이벤트 만들기
closeBtns.forEach((closeBtn, index, myself) => {
	closeBtn.addEventListener("click", (e) => {
		// 자신의 부모의 가장 큰 부모 찾기(pop_info_num)
		e.target.parentElement.parentElement.parentElement.style.display = "none";
	});
});

/* 파일 업로드 시작 */

var fileNo = 0;
var filesArr = new Array();

/* 첨부파일 추가 */
function addFile(obj) {
	var maxFileCnt = 5; // 첨부파일 최대 개수
	var attFileCnt = document.querySelectorAll(".filebox").length; // 기존 추가된 첨부파일 개수
	var remainFileCnt = maxFileCnt - attFileCnt; // 추가로 첨부가능한 개수
	var curFileCnt = obj.files.length; // 현재 선택된 첨부파일 개수

	// 첨부파일 개수 확인
	if (curFileCnt > remainFileCnt) {
		alert("첨부파일은 최대 " + maxFileCnt + "개 까지 첨부 가능합니다.");
	}

	for (var i = 0; i < Math.min(curFileCnt, remainFileCnt); i++) {
		const file = obj.files[i];

		// 첨부파일 검증
		if (validation(file)) {
			// 파일 배열에 담기
			var reader = new FileReader();
			reader.onload = function() {
				filesArr.push(file);
			};
			reader.readAsDataURL(file);

			// 목록 추가
			let htmlData = "";
			htmlData += '<div id="file' + fileNo + '" class="filebox">';
			htmlData += '   <p class="name">' + file.name + "</p>";
			htmlData +=
				'   <a class="delete" onclick="deleteFile(' +
				fileNo +
				');"><img src="../images/home/dash-square.svg" alt="삭제버튼" /></a>';
			htmlData += "</div>";
			$(".file-list").append(htmlData);
			fileNo++;
		} else {
			continue;
		}
	}
	// 초기화
	document.querySelector("input[type=file]").value = "";
}

/* 첨부파일 검증 */
function validation(obj) {
	const fileTypes = [
		"application/pdf",
		"image/gif",
		"image/jpeg",
		"image/png",
		"image/bmp",
		"image/tif",
		"application/haansofthwp",
		"application/x-hwp",
	];
	if (obj.name.length > 100) {
		alert("파일명이 100자 이상인 파일은 제외되었습니다.");
		return false;
	} else if (obj.size > 100 * 1024 * 1024) {
		alert("최대 파일 용량인 100MB를 초과한 파일은 제외되었습니다.");
		return false;
	} else if (obj.name.lastIndexOf(".") == -1) {
		alert("확장자가 없는 파일은 제외되었습니다.");
		return false;
	} else if (!fileTypes.includes(obj.type)) {
		alert("첨부가 불가능한 파일은 제외되었습니다.");
		return false;
	} else {
		return true;
	}
}

/* 첨부파일 삭제 */
function deleteFile(num) {
	document.querySelector("#file" + num).remove();
	filesArr[num].is_delete = true;
}

/* 폼 전송 */
function submitForm() {
	// 폼데이터 담기
	var form = document.querySelector("form");
	var formData = new FormData(form);
	for (var i = 0; i < filesArr.length; i++) {
		// 삭제되지 않은 파일만 폼데이터에 담기
		if (!filesArr[i].is_delete) {
			formData.append("attach_file", filesArr[i]);
		}
	}

	$.ajax({
		method: "POST",
		url: "/register",
		dataType: "json",
		data: formData,
		async: true,
		timeout: 30000,
		cache: false,
		headers: { "cache-control": "no-cache", pragma: "no-cache" },
		success: function() {
			alert("파일업로드 성공");
		},
		error: function(xhr, desc, err) {
			alert("에러가 발생 하였습니다.");
			return;
		},
	});
}

/* 파일 업로드 끝 */
