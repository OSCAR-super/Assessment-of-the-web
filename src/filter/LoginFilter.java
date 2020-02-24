package filter;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        if (!request.getRequestURI().contains("/homepage")){
            User u=(User) request.getSession().getAttribute("user");
            if (u==null){
                Cookie[] cookies=request.getCookies();
                Cookie ck=null;
                for (Cookie c:cookies){
                    if (c.getName().equals("autoLogin")){
                        ck=c;
                    }
                }
                if (ck!=null){
                    String userName=ck.getValue().split("-")[0];
                    String pwd=ck.getValue().split("-")[1];
                    UserService service=new UserServiceImpl();
                    User us=service.Login(userName,pwd);
                    if (us!=null){
                        request.getSession().setAttribute("user",us);
                    }
                }
            }

        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
