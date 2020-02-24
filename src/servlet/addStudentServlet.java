package servlet;

import Tools.JDBCUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Students;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public addStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String filename = null;
        int sno=-1;
        String sname=null;
        int kaohename=-1;
        boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if(isMultipart)
        {
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            try {
                List<FileItem> items=upload.parseRequest(request);
                Iterator<FileItem> it = items.iterator();
                while(it.hasNext())
                {
                    FileItem item = it.next();
                    String itemname = item.getFieldName();


                    if(item.isFormField())
                    {
                        if(itemname.equals("sid"))
                        {
                            sno=Integer.parseInt(item.getString("utf-8"));

                        }else if(itemname.equals("sname"))
                        {
                            sname=item.getString("utf-8");

                        }else if(itemname.equals("kaohename"))
                        {
                            kaohename=Integer.parseInt(item.getString("utf-8"));
                        }else
                        {
                            System.out.println("其他字段");
                        }

                    }else
                    {
                        filename=item.getName();
                        //String path=request.getSession().getServletContext().getRealPath("upload");
                        String path="F:\\upload";
                        File file=new File(path,filename);
                        item.write(file);
                        request.setAttribute("news", filename+"上传成功,谢谢分享");

                        //System.out.println(filename+"上传成功!!!");

                    }

                }
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }




        Students s=new Students();
        s.setFile(filename);
        s.setSid(sno);
        s.setSname(sname);
        s.setKaohename(kaohename);
        UserService service=new UserServiceImpl();
        try {
            service.addStudent(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/chenggong.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
