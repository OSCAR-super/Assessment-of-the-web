package servlet;

import pojo.PageBean;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/FindUserByConditionServlet")
public class FindUserByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage=request.getParameter("currentPage");
        String rows=request.getParameter("rows");
        if (currentPage==null||currentPage.equals("")){
            currentPage="1";
        }
        if (rows==null||rows.equals("")){
            rows="5";
        }

        Map<String,String[]>map=request.getParameterMap();
        UserService service=new UserServiceImpl();
        List<User> lst=service.findUserByCondition(Integer.parseInt(currentPage),Integer.parseInt(rows),map);
        int totalCount=service.findUserByConditionCount(map);
        PageBean<User>pb=new PageBean<User>();
        pb.setList(lst);
        pb.setTotalCount(totalCount);
        int totalPage=totalCount%Integer.parseInt(rows)==0?totalCount/Integer.parseInt(rows):totalCount/Integer.parseInt(rows)+1;
        pb.setTotalPage(totalPage);
        pb.setRows(Integer.parseInt(rows));
        pb.setCurrentPage(Integer.parseInt(currentPage));
        request.setAttribute("pb",pb);
        request.setAttribute("condition",map);
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
