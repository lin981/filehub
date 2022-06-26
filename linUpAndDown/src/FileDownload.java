import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/df")
public class FileDownload extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        //通过请求获取多分布的集合
        String realPath = req.getServletContext().getRealPath("/WEB-INF/upload");

        HashMap<String, String> fileanmes = new HashMap<>();
        UpUtil.getFileList(realPath,fileanmes);
        System.out.println(fileanmes.toString()+"------------");
        req.setAttribute("filenames",fileanmes);
        System.out.println(fileanmes.size());
        req.getRequestDispatcher("/list.jsp").forward(req,resp);


    }
}
