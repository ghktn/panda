package com.playdata.panda.config;

import com.playdata.panda.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 기능 : 인터셉터를 등록할 수 있습니다.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * addInterceptors
     * @param registry
     * 기능 : 인터셉터를 등록할 수 있습니다.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/",
                        "/login", "/signup", "/singout",
                        "/css/**",
                        "/images/**",
                        "/js/**",
                        "/fonts/**",
                        "/recruitment",
                        "/region_emd", "/region_sgg",
                        // 모집공고
//                        "/recruitment", "/recruitment/detail/{id}", "/recruitment-detail",
                        // 공지사항
                        "/notice",
                        // 에러페이지
                        "/error"
                );

    }
}
