package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String files=request.getParameter("filename");



            FileInputStream input = new FileInputStream("F:\\upload\\"+files);

            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), Charset.forName("GBK"));
            ZipEntry ze = null;



                while((ze=zipInputStream.getNextEntry())!= null){

                    response.getWriter().print("文件名：" + ze.getName() + " 文件大小：" + ze.getSize() + " bytes"+"<br>");

                    response.getWriter().print("文件内容："+"<br>");
                    BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream,Charset.forName("GBK")));

                    String line;

                    while ((line = br.readLine()) != null) {
                        response.getWriter().print(line+"<br>");


                }

            }
            zipInputStream.closeEntry();
            input.close();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }




}
