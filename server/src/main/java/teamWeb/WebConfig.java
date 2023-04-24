package teamWeb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import teamWeb.intercept.PageViewIntercept;

import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private PageViewIntercept pageViewIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginIntercept());//可以直接new 也可以属性注入
        registry.addInterceptor(pageViewIntercept).
                addPathPatterns("/**");    // 拦截所有 url
    }
}
