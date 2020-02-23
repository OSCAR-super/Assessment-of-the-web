package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String files=request.getParameter("filename");
        File file=new File("F:\\upload\\"+files);
        try {

            InputStreamReader isr = new InputStreamReader(new FileInputStream((file)), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String content;
            try {

                while((content=br.readLine())!=null){

                    response.getWriter().print(content+"<br>");


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }




}
