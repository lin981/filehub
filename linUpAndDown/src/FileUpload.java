import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/ful")
@MultipartConfig(maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024 * 300)
public class FileUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //通过请求获取多分布的集合
        String realPath =req.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            String fileName = part.getSubmittedFileName();
            if (fileName!=null){
                String newFileName=UpUtil.newFileNme(fileName);
                part.write(realPath+File.separator+newFileName);

            }else {
                String name = part.getName();
                String parameter = req.getParameter(name);
                System.out.println(parameter);

            }
        }

    }
}
