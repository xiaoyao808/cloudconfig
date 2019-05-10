package com.starv.firstspringboot.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//--xml 转移到 配置类
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub preHandle

		//把拦截器 加入到这里
		 registry.addInterceptor(new LoginInteceptor())
		.addPathPatterns("/**")///**代表拦截所有
		.excludePathPatterns("/login")//排除login的拦截
		.excludePathPatterns("/verifyUname")//排除login的拦截
		.excludePathPatterns("/index.jsp")//排除login.html的拦截
		.excludePathPatterns("/js/jquery-3.3.1.min.js")//排除login.html的拦截
		.excludePathPatterns("/js/jquery.cookie.js");//排除login.html的拦截
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
