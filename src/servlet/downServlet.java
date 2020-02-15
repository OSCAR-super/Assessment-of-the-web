package servlet;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet("/downServlet")
public class downServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public downServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("filename");

        String filePath = "F:\\upload";


        response.reset();
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        OutputStream os = response.getOutputStream();
        try {
            FileInputStream fis = new FileInputStream(filePath + fileName);
            try {
                byte[] buffer = new byte[1024 * 10];
                for (int read; (read = fis.read(buffer)) != -1;) {
                    os.write(buffer, 0, read);
                }
            } finally {
                fis.close();
            }
        } finally {
            os.close();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
