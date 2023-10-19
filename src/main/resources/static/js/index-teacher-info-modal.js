/**
 * 기능 : 카테고리 소분류를 출력할 수 있습니다.
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

/**
 * 기능 : 카테고리 소분류 출력할 수 있습니다.
 */
function success_run(resultData) {

	let result = "";
	result += "<option value=''>선택</option>"
	resultData.forEach(function(data) {
		result += "<option value=" + data.category_sub_id + ">" + data.category_sub_name + "</option>"

	});
	$("#categorySubId").html(result);
}

/**
 * 기능 : ajax 에러 처리할 수 있습니다.
 */
function error_run(obj, resMsg, errorMsg) {
	console.log("error");
	console.log(obj);
	console.log(resMsg);
	console.log(errorMsg);
}

// 10.19 추가 시작

/**
 * 기능 : 처음 시작 회원 학생, 선생님 상태 전환버튼 확인
 */
const changeUserDivisionBtnStart = async (changeSignal) => {
	if (changeSignal !== "T ") {
//		console.log("학생으로 들어왔다.");
		$(".btn.change").html("선생님으로 전환하기");

	} else {
//		console.log("선생으로 들어왔다.");
		$(".btn.change").html("학생으로 전환하기");
	}
}

/**
 * 기능 : 회원 학생, 선생님 상태 전환버튼 전환
 */
const changeUserDivisionBtn = async (changeSignal) => {

	// 선생님 데이터가 있는지 확인 요청하기
	try {
		const teacherInfo = await confirmTeacher();
		// 선생님 정보 없으면 전환 못한다.
		if(teacherInfo === "false") {
			return
		}
	} catch(error) {
		console.log(error);
	}

	if (changeSignal === "T ") {
		try {
			// 회원의 유저 구분 아이디를 '학생'으로 변경할 수 있습니다.
			await changeUserDivisionIdForStudent();
			$(".btn.change").html("선생님으로 전환하기");
		} catch(err) {
			console.log(err);
		}
	} else {
		try {
			// 회원의 유저 구분 아이디를 '선생님'으로 변경할 수 있습니다.
			await changeUserDivisionIdForTeacher();
			$(".btn.change").html("학생으로 전환하기");
		} catch(err) {
			console.log(err);
		}
	}
}

/**
 * 기능 : 회원의 유저 구분 아이디를 '선생님'으로 변경할 수 있습니다.
 */
const changeUserDivisionIdForTeacher = async () => {

	const url = "http://localhost:9010/users/divisionid/teacher";
	// 유저 구분 아이디는 'T'로 변경된다.
	const response = await fetch(url, {
		method: "post"
	});

	return response.text();
}

/**
 * 기능 : 회원의 유저 구분 아이디를 '학생'으로 변경할 수 있습니다.
 */
const changeUserDivisionIdForStudent = async () => {

	const url = "http://localhost:9010/users/divisionid/student";
	// 유저 구분 아이디는 'S'로 변경된다.
	const response = await fetch(url, {
		method: "post"
	});

	return response.text();
}

/**
 * 기능 : 회원의 UserDivisionId(유저 구분 아이디) 데이터 불러오기
 */
const getUserDivisionId = async () => {

	const url = "http://localhost:9010/users/info";

	const result = await fetch(url, {
		method: "get",
		dataType: "application/json"
	});

	return result.json();
}

/**
 * 기능 : 회원의 UserDivisionId(유저 구분 아이디) 데이터 반환하기
 */
const confirmUserDivisionId = async () => {

	try {
		const user = await getUserDivisionId();

		return user.user_division_id;
	} catch(err) {
		console.log(err);
	}
}

/**
 * 기능 : 선생님 정보가 있는지 요청합니다.
 */
const getTeacherInfo = async () => {

	const url = "http://localhost:9010/teacherchange/info";

	const result = await fetch(url, {
		method: "get"
	});

	return result.text();
}

/**
 * 기능 : 선생님 정보 데이터가 있는지 확인할 수 있습니다.
 */
const confirmTeacher = async () => {

	try {
		// 선생님 정보 불러오기
		const teacherInfo = await getTeacherInfo();
		console.log("confirmTeacher teacherInfo : ", teacherInfo);
		// 선생님 정보 반환하기
		return teacherInfo;
	} catch(error) {
		console.log(error);
	}
}

// TODO : 10.19 추가 끝

// open 버튼 불러오기
const openBtns = document.querySelectorAll(".teacher_info_open");
// close 버튼 불러오기
const closeBtns = document.querySelectorAll(".teacher_info_close");
// 팝업창 선택하기
let targetId = "";

// TODO : 10.19 ~ 이후 추가한 부분 시작

// 처음 시작
// 선생님 전환 버튼인지 학생 전환 버튼인지 구분해 준다.
async function start() {
	const changeSignal = await confirmUserDivisionId(); // 바뀜상태
//	console.log("cangeSignal : ", changeSignal);
	// 처음 회원 학생, 선생님 상태 전환버튼 전환 값을 결정한다.
	changeUserDivisionBtnStart(changeSignal);
}
// 처음 시작 실행
start();

// TODO : 10.19 ~ 이후 추가한 부분 끝

// open이벤트 만들기
openBtns.forEach((openBtn, index) => {

	// TODO : 10.19 이전에 있던 부분
	openBtn.addEventListener("click", async (event) => {

		// TODO : 10.19 ~ 이후 추가한 부분 시작

		// 선생님 데이터가 있는지 확인 요청하기
		const teacherInfo = await confirmTeacher();
//		console.log("teacherInfo : ", teacherInfo);

		// 선생님 전환 버튼인지 학생 전환 버튼인지 구분해 준다.
		const changeSignal = await confirmUserDivisionId(); // 바뀜상태
//		console.log("버튼 : ", changeSignal);
		// 회원 학생, 선생님 상태 전환버튼 전환 값을 결정한다.
		await changeUserDivisionBtn(changeSignal);

		// TODO : 10.19 ~ 이후 추가한 부분 끝

		// 선생님 정보가 없으면 창을 연다.
		console.log(teacherInfo === "false");
		if(teacherInfo === "false") {

			// TODO : 10.19 이전 추가한 부분 시작

			// 팝업창 id 찾기
			targetId = event.target.parentElement.getAttribute("href");
			// 팝업창 열기
			const popInfo = document.querySelector(targetId);
			// 화면 보이기
			popInfo.style.display = "block";
			// 카테고리 대분류 요청하기
			$.ajax({
				url: "/cate-main",
				type: "get",
				success: success_main_run,
				error: error_run
			})

			// TODO : 10.19 이전 추가한 부분 끝
		}
	});
});

/**
 * 기능 : 카테고리 대분류를 출력할 수 있습니다.
 */
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

// 기능 :  선생님 정보 입력 모달 닫을 수 있습니다.
const closeTheacherInfoModal = () => {
	const popInfo = document.querySelector("#pop_info");
	popInfo.style.display = "none";
}

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
	// 파일이 초기화 된다
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
	// TODO : 현재 사용 안 한다. 파일 확장자를 정하고 사용해 본다.(10.18~)
//	} else if (!fileTypes.includes(obj.type)) {
//		alert("첨부가 불가능한 파일은 제외되었습니다.");
//		return false;
//	} 
	} else {
		return true;
	}
}

/* 첨부파일 삭제 */
function deleteFile(num) {
	document.querySelector("#file" + num).remove();
	// 내부의 데이터를 저장할 수 있다.
	filesArr[num].is_delete = true;
}

/* 폼 전송 */
function submitForm() {
	// 폼데이터 담기
	var form = document.querySelector("form");
//	var formData = new FormData(form);
	var formData = new FormData();
	for (var i = 0; i < filesArr.length; i++) {
		// 삭제되지 않은 파일만 폼데이터에 담기
		if (!filesArr[i].is_delete) {
			console.log(filesArr[i]);
			
			formData.append("files", filesArr[i]);
		}
	}
	// 데이터 담기
	// TODO : 카테고리 대뷴류, 소분류 데이터 validation 처리하기
	// TODO : 선생님 소개글 validation  처리하기
	const categoryMainIdValue = document.querySelector("#categoryMainId").value;
	const categorySubIdValue = document.querySelector("#categorySubId").value;
	const commentValue = document.querySelector("#comment").value;
	
	
	const teacherChange = {
		category_main_id: categoryMainIdValue,
		category_sub_id: categorySubIdValue,
		teacher_introduce: commentValue
	}
	// 다른 데이터 formData에 담기
	formData.append("teacherChange", new Blob([JSON.stringify(teacherChange)], {type: 'application/json'}));
	
	$.ajax({
		method: "POST",
		url: "/teacherchange/save",
		dataType: "text",
		enctype: "multipart/form-data",
		processData: false,
		contentType: false,
		data: formData,
		async: true,
		timeout: 30000,
		cache: false,
		headers: { "cache-control": "no-cache", pragma: "no-cache" },
		success: function() {
			alert("선생님 등록이 완료되었습니다.\n선생님 전환이 가능합니다.");
			closeTheacherInfoModal();
		},
		error: function(xhr, desc, err) {
			alert("에러가 발생 하였습니다.");
			console.log(xhr);
			return;
		},
	});
}

/* 파일 업로드 끝 */
