package servlet;

import pojo.PageBean;
import pojo.Students;
import pojo.Students;
import pojo.User;
import pojo.kaohe;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@WebServlet( "/FindStudentByConditionServlet")
public class FindStudentByConditionServlet extends HttpServlet {
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

        Map<String,String[]> map=request.getParameterMap();
        UserService service=new UserServiceImpl();
        List<Students> lst=service.findStudentByCondition(Integer.parseInt(currentPage),Integer.parseInt(rows),map);
        int totalCount=service.findStudentByConditionCount(map);
        PageBean<Students> pbs=new PageBean<Students>();
        pbs.setList(lst);
        pbs.setTotalCount(totalCount);
        int totalPage=totalCount%Integer.parseInt(rows)==0?totalCount/Integer.parseInt(rows):totalCount/Integer.parseInt(rows)+1;
        pbs.setTotalPage(totalPage);
        pbs.setRows(Integer.parseInt(rows));
        pbs.setCurrentPage(Integer.parseInt(currentPage));
        request.setAttribute("pbs",pbs);
        request.setAttribute("condition",map);

        request.getRequestDispatcher("/page.jsp").forward(request,response);

    }


}
