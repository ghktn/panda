
/**
 * TODO : index-teacher-info-modal.js 파일에 같은 코드가 있어 중복 기능이라 주석 처리하였습니다.(10.19~)
 */


///**
// * 기능 : 선생님, 학생 상태로 전환 기능입니다.
// */
//$(document).ready(() => {
//	// 처음 시작
//	let changeSignal = confirmUserDivisionId(); // 바뀜상태
//	// 회원 학생, 선생님 상태 전환버튼 전환 값을 결정한다.
//	changeUserDivisionBtn(changeSignal);
//	
//	// 회원 전환하기 버튼 클릭했을 때
//	$(".btn.change").click(() => {
//		changeUserDivisionBtn();
//	});
//});

/**
 * TODO : index-teacher-info-modal.js 파일에 같은 코드가 있어 중복 기능이라 주석 처리하였습니다.(10.19~)
 */ 

///**
// * 기능 : 회원 학생, 선생님 상태 전환버튼 전환
// */
//const changeUserDivisionBtn = async (changeSignal) => {
//	if (changeSignal !== "T ") {
//		try {
//			// 회원의 유저 구분 아이디를 '학생'으로 변경할 수 있습니다.
//			await changeUserDivisionIdForStudent();		
//			$(".btn.change").html("선생님으로 전환하기");
//		} catch(err) {
//			console.log(err);
//		}
//		
//	} else {
//		try {
//			// 회원의 유저 구분 아이디를 '선생님'으로 변경할 수 있습니다.
//			await changeUserDivisionIdForTeacher();
//			$(".btn.change").html("학생으로 전환하기");
//		} catch(err) {
//			console.log(err);
//		}
//	}
//}
//
///**
// * 기능 : 회원의 유저 구분 아이디를 '선생님'으로 변경할 수 있습니다.
// */
//const changeUserDivisionIdForTeacher = async () => {
//	
//	const url = "/users/divisionid/teacher";
//	// 유저 구분 아이디는 'T'로 변경된다.
//	const response = await fetch(url, {
//		method: "put"
//	});
//	
//	return response.json();
//}
//
///**
// * 기능 : 회원의 유저 구분 아이디를 '학생'으로 변경할 수 있습니다.
// */
//const changeUserDivisionIdForStudent = async () => {
//	
//	const url = "/users/divisionid/student";
//	// 유저 구분 아이디는 'S'로 변경된다.
//	const response = await fetch(url, {
//		method: "put"
//	});
//	
//	return response.json();
//}
// 
///**
// * 기능 : 회원의 UserDivisionId(유저 구분 아이디) 데이터 불러오기
// */
//const getUserDivisionId = async () => {
//	
//	const url = "/users/info";
//	
//	const result = await fetch(url, {
//		method: "get",
//		dataType: "application/json"
//	});
//	
//	return result.json();
//}
//
///**
// * 기능 : 회원의 UserDivisionId(유저 구분 아이디) 데이터 불러오기
// */
//const confirmUserDivisionId = async () => {
//	
//	try {
//		const user = await getUserDivisionId();
//		
//		return user.user_division_id;
//	} catch(err) {
//		console.log(err);
//	}
//}

/**
 * TODO : index-teacher-info-modal.js 파일에 같은 코드가 있어 중복 기능이라 주석 처리하였습니다.(10.19~)
 */ 

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