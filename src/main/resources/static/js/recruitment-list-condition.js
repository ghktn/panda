/**
 * 기능 : 모집 공고 조건에 따른 리스트를 불러올 수 있습니다.
 */

// 필드
// 조건 담기 변수
let condition = {
	categoryList: [],
	locationList: [],
	maxStdCountList: [],
	payPriceList: [],
	wishDayList: [],
	lectureTypeList: [],
	genderList: [],
	
	// page 처리
	count: 0,// 전체 리스트 개수
	bound: 16,// 한 페이지 당 나오는 게시글 개수
	nowPage: 1// 현재 페이지
}

// 검색 버튼 변수
const conditionBtn = document.querySelector("#conditionBtn");

// 조건들을 불러와서 담은 변수
const categoryList = Array.from(document.querySelectorAll(".category"));// 카테고리(ex) 패션/뷰티
const locationList = Array.from(document.querySelectorAll(".location"));// 시도
const maxStdCountList = Array.from(document.querySelectorAll(".maxStdCount"));// 수업에 참여 가능한 최대 학생수
const payPriceList = Array.from(document.querySelectorAll(".payPrice"));// 수강료(low, high) 
const wishDayList = Array.from(document.querySelectorAll(".wishDay"));// 수업 희망 요일
const lectureTypeList = Array.from(document.querySelectorAll(".lectureType"));// 수업형태
const genderList = Array.from(document.querySelectorAll(".gender"));// 모집대상 성별

// 메서드
/**
 * 기능 : 조건이 체크되어있는지 확인할 수 있습니다.
 */
const handleCheckingCdClick = (a) => {
	// 조건 리스트
	const cdL = a.filter((cd) => {
		return cd.checked === true;
	}).map((cd) => {
		console.log(cd);
		return cd.value;
	});
	return cdL;
}

/**
 * 기능 : 조건이 변경었는지 확인할 수 있습니다.
 */
const handleCheckingCdChange = (a) => {
	// 조건 리스트
	const cdL = a.filter((cd) => {
		return cd.value !== '' || cd.value !== 0;
	}).map((cd) => {
		console.log(cd);
		return cd.value;
	});
	return cdL;
}

/**
 * 기능 : 조건들에 이벤트를 등록할 수 있습니다. (사용 못함 : 10.16~)
 * params : cdList : 조건 리스트
 */
const registerEventForCdList = (list, name) => {
	list.forEach((cd) => {
	cd.addEventListener('click', () => {
		const valueList = handleCheckingCdClick(list);
		condition.categoryList = valueList;
//		condition = {...condition, ...value};
		console.log(condition);
	})
  });
}

/**
 * 기능 : 조건 파라미터를 던져서 List를 불러올 수 있습니다.
 */
const requestRecruitmentList = async (data) => {
	
	const url = "/recruitments/search";
	const jsonData = JSON.stringify(data);
	const result = await fetch(url, {
		method: "post",
		headers: {
			"Content-Type": "application/json"
		},
		body: jsonData	
	});
	
	return result.json();
}

/**
 * 기능 : 조건 검색을 클릭했을 때 List를 화면에 보여줄 수 있습니다.
 * TODO : 여기하기(10.16~)
 */
const handleConditionBtnClick = async () => {
	// 컨디션을 보낸다.
	try {
		// list를 받아온다.
		const boardMap = await requestRecruitmentList(condition);
		console.log(boardMap);// ok
		// 화면에 list를 보여준다.
		createView(boardMap);
		
		
		
		
	} catch(error) {
		console.log(error);
	}
	
}


// 실행 메서드
const start = () => {
	// 모든 조건에 이벤트를 등록하기
	categoryList.forEach((cd) => {
		cd.addEventListener('click', () => {
			const valueList = handleCheckingCdClick(categoryList);
			condition.categoryList = valueList;
	//		condition = {...condition, ...value};
			console.log(condition);
		})
	})
	//
	locationList.forEach((cd) => {
		cd.addEventListener('click', () => {
			const valueList = handleCheckingCdClick(locationList);
			condition.locationList = valueList;
			console.log(condition);
		})
	})
	//
	maxStdCountList.forEach((cd) => {
		cd.addEventListener('click', () => {
			const valueList = handleCheckingCdClick(maxStdCountList);
			condition.maxStdCountList = valueList;
			console.log(condition);
		})
	})
	// TODO : 이벤트를 다른 걸 찾아보자
	// 수강료
	payPriceList.forEach((cd) => {
		cd.addEventListener('change', () => {
			const valueList = handleCheckingCdChange(payPriceList);
			condition.payPriceList = valueList;
			console.log(condition);
		})
	})
	//
	wishDayList.forEach((cd) => {
		cd.addEventListener('click', () => {
			const valueList = handleCheckingCdClick(wishDayList);
			condition.wishDayList = valueList;
			console.log(condition);
		})
	})
	//
	lectureTypeList.forEach((cd) => {
		cd.addEventListener('click', () => {
			const valueList = handleCheckingCdClick(lectureTypeList);
			condition.lectureTypeList = valueList;
			console.log(condition);
		})
	})
	//
	genderList.forEach((cd) => {
		cd.addEventListener('click', () => {
			const valueList = handleCheckingCdClick(genderList);
			condition.genderList = valueList;
			console.log(condition);
		})
	})
	
	// 클릭버튼을 눌렸을 때 모집 공고 리스트를 받아온다.
	conditionBtn.addEventListener('click', () => {
		handleConditionBtnClick();
	});
};

// 실행 메서드 호출
start();


/**
 * 기능 : 화면을 구현할 수 있습니다.
 */
const createView = (boardMap) => {
	
	// 전체카운트를 condition에 대입한다.
	condition.count = boardMap.totalCount;
	console.log(condition);
	
	// boardList를 불러온다.
 	let boardList = [];
 	boardList = boardMap.boardList;
 	
 	const resultView = '';// view를 담는 변수
 	
 	// view를 만든다.

	resultView += `
		<div th:each="board : ${boardList}" class="col-sm-6 col-md-3" >
    		<div class="caption" th:onclick="|location.href='@{/recruitment/detail/}${board.recruitment_id}'|">
                <div class="notice-title">
                    <h4 th:text="${board.title}">스프링 한 달 마스터</h4>
                </div>
                <!-- TODO : 인증 체크부분 있는지 확인하기 -->
                <div class="badge">판다인증🐼</div>
                <div class="location">
                	<span>지역 : </span> 
                	<span th:text="${board.sd_name}">서울 독산동</span>
                	<span th:text="${board.sgg_name}">서울 독산동</span>
                	<span th:text="${board.emd_name}">서울 독산동</span>
                </div>
                <div class="type">
                	<span>수업 형태 : </span>
                	<th:block th:switch=${board.lecture_type}  >
                		<span th:case="N" th:text="무관">온라인</span>
                		<span th:case="0" th:text="온라인">온라인</span>
                		<span th:case="1" th:text="오프라인">온라인</span>
                		<span th:case="*" th:text="그 외">온라인</span>
                	</th:switch>
                </div>
                <div class="stu-num">
                	<span>학생 수 : </span> 
                	(<span th:text="${board.current_std_count}">0</span>/<span th:text="${board.max_std_count}">0</span>)명
                </div>
                <div class="price">
                	<span>수강료 : </span>
                	<!-- TODO : class의 수강비인지 모집공고의 희망수강비인지 확인 필요하다 -->
                	<span th:text="${board.wish_pay}">200,000</span>원
               	</div>
                <div class="t-nickname">
                    <div>
	                  <span>
	                  	<!-- TODO : 개인정보 상세보기 이동 필요하다. -->
	                    <a href="###">
	                      <br/>
	                      <img th:src="@{/hello}" src="images/home/girl1.jpg" width="20px"/>
	                      <span th:text="${board.nickname}">스프링장인</span>
	                    </a>
	                  </span>
                      <span id="star">⭐<span th:text="${board.review_score}">4.5</span></span>
                    </div>
                </div>
                <!-- t-nickname -->
            </div>
            <!-- caption -->
    	</div>
    	<!-- boardList 출력 끝 -->
	`;
	
	// list 넣기
	const noticeView = document.querySelector("#noticeView");
	noticeView.innerHTML = resultView;
 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
