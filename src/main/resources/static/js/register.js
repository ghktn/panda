/*
비밀번호 일치 확인
*/
function selectAll(selectAll) {
	const checkboxes
		= document.getElementsByName("primaryinfo");

	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked;
	})
}

function isSame() {
	var pw = document.getElementById("password").value;
	var confirmPW = document.getElementById("passwordcheck").value;
	if (document.getElementById("password").value != '' && document.getElementById("passwordcheck").value != '') {
		if (document.getElementById("password").value == document.getElementById("passwordcheck").value) {
			document.getElementById("same").innerHTML = '비밀번호가 일치합니다.';
			document.getElementById("same").style.color = 'blue';
		} else {
			document.getElementById("same").innerHTML = '비밀번호가 일치하지 않습니다.';
			document.getElementById("same").style.color = 'red';
		}
	}
}

const birthYearEl = document.getElementById("year")
// option 목록 생성 여부 확인
isYearOptionExisted = false;
birthYearEl.addEventListener('focus', function() {
	if (!isYearOptionExisted) {
		isYearOptionExisted = true
		for (var i = 1940; i <= 2022; i++) {
			// option element 생성
			const YearOption = document.createElement("option")
			YearOption.setAttribute("value", i)
			YearOption.innerText = i
			// birthYearEl의 자식 요소로 추가
			this.appendChild(YearOption);
		}
	}
});

