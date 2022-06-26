import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

@WebServlet("/dnf")
public class FileDownf extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        //通过请求获取多分布的集合

        String realPath = req.getServletContext().getRealPath("/WEB-INF/upload");

        String filename=req.getParameter("filename");
        resp.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(filename,"utf-8"));
        String path=realPath+ File.separator+filename;

        FileInputStream fileInputStream = new FileInputStream(path);
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024*1024*100];
        int len=0;
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        outputStream.close();
        fileInputStream.close();

    }
}
