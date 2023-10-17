/**
 * 비밀번호 일치
 */
function isSame() {
	var pw = document.getElementById("password").value;
	var confirmPW = document.getElementById("passwordcheck").value;
	if (document.getElementById("password").value != '' && document.getElementById("passwordcheck").value != '') {
		if (document.getElementById("password").value == document.getElementById("passwordcheck").value) {
			document.getElementById("same").innerHTML = '비밀번호가 일치합니다.';
			document.getElementById("same").style.color = 'blue';
		}
		else {
			document.getElementById("same").innerHTML = '비밀번호가 일치하지 않습니다.';
			document.getElementById("same").style.color = 'red';
		}
	}
}
/*
닉네임 중복 확인
*/
function checkNickname() {
	var nickname = document.getElementById("nickname").value;
//	var existingNickname = "aa";
	const existingNickname = $("#nickname").val();

	// 닉네임 중복 여부 확인
	if (nickname === existingNickname) {
		document.getElementById("check").textContent = "이미 사용 중인 닉네임입니다.";
	} else {
		document.getElementById("check").textContent = "사용 가능한 닉네임입니다.";
	}
	
}
