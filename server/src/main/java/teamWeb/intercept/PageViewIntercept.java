package teamWeb.intercept;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import teamWeb.homepage.service.HomeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class PageViewIntercept implements HandlerInterceptor {
    @Autowired
    HomeService homeService;
    // 返回 true 表示拦截判断通过，可以访问后面的接口
    // 返回 false 表示拦截未通过，直接返回结果给前端
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 1.得到 HttpSession 对象
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("view") != null) {
            // 表示已经登录
        }else if (session != null) {
            session.setMaxInactiveInterval(1800);
            session.setAttribute("view",1);
            homeService.pageView();
        }
        return true;
    }
}