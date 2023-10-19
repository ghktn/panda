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
$(document).ready(function() {
	$("#checkNicknameButton").click(function() {
		var nickname = $("#nickname").val();

		// AJAX 요청
		$.ajax({
			url: "/checkNickname",
			type: "POST",
			data: { nickname: nickname },
			success: function(response) {
				$("#resultMessage").text(response.message);
			}
		});
	});
});

