package com.playdata.panda.interceptor;

import com.playdata.panda.dto.User;
import com.playdata.panda.util.SessionConst;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //로그인사용자인 경우 세션에 user라는 이름의 어트리뷰트가 저장되어 있으므로
        //user가 없으면 로그인이 처리되지 않음을 의미
        HttpSession session = request.getSession(false);

        String requestUrl = request.getRequestURI();
        System.out.println("requestUrl = " + requestUrl);

        System.out.println(" 로그인 필터 들어옴");
        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            // 여기서 로그인 세션이 없으면 화면에 전달할 내용이 담긴 로직을 만들어주면 될것같다
            response.sendRedirect("/login?returnUrl="+requestUrl);
            //로그인하지 않은 사용자는 다음(뷰에서 선택한 path로 이동되지 않도록)으로 넘어가지 않도록 false를리턴
            return false;
        }
        //로그인된 사용자는 다음으로 넘어갈 수 있도록 true리턴
        return true;
    }
}
