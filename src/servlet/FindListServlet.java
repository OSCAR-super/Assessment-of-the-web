package servlet;

import pojo.PageBean;
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
import java.util.List;
import java.util.Map;

@WebServlet( "/FindListServlet")
public class FindListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
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
        List<kaohe> lst=service.findkaohe(Integer.parseInt(currentPage),Integer.parseInt(rows),map);
        int totalCount=service.findkaohe(map);
        PageBean<kaohe> pb2=new PageBean<kaohe>();
        pb2.setList(lst);
        pb2.setTotalCount(totalCount);
        int totalPage=totalCount%Integer.parseInt(rows)==0?totalCount/Integer.parseInt(rows):totalCount/Integer.parseInt(rows)+1;
        pb2.setTotalPage(totalPage);
        pb2.setRows(Integer.parseInt(rows));
        pb2.setCurrentPage(Integer.parseInt(currentPage));
        request.setAttribute("pb2",pb2);
        request.setAttribute("condition",map);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

}
