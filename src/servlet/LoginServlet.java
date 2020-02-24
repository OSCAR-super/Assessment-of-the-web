package servlet;

import Tools.JDBCUtils;
import jdk.nashorn.internal.parser.Token;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("user");
        String pwd=request.getParameter("password");
        String vcode=request.getParameter("verifycode");
        String ocode=(String)request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        UserService service=new UserServiceImpl();
        if (vcode.equalsIgnoreCase(ocode)){
            String sql="SELECT *FROM user WHERE username=? AND password=?";
            User u=null;
            u=service.Login(username,pwd);
            Cookie cookie=new Cookie("autoLogin",username+"-"+pwd);
            cookie.setMaxAge(3600);
            cookie.setPath(request.getContextPath()+"/");
            response.addCookie(cookie);
            if (u!=null){
                    request.getSession().setAttribute("user",u);
                    response.sendRedirect(request.getContextPath()+"/FindListServlet");
            }else {
                    request.setAttribute("login_msg","用户名或密码不正确!");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
            }


        }else {
            request.setAttribute("login_msg","验证码不正确!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
