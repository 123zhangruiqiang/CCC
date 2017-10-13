package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("hahhahah");
        try {
            String JSESSIONID=httpServletRequest.getSession().getAttribute("JSESSIONID").toString();
            String sso_Token=httpServletRequest.getSession().getAttribute("sso-Token").toString();
            System.out.println("xixixixixixixix");
            return true;
        }catch (Exception e){
            System.out.println("当前会话不存在");
            httpServletResponse.sendRedirect("WEB-INF/FileIndex.jsp");

        }
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
