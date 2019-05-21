package Include;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 包含
 */
@WebServlet("/IncludeOneServlet")
public class IncludeOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("aaa", "AAA"); //设置响应头
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("我是 IncludeOneServlet 响应体"+"<br/>"); //设置响应体
        req.setAttribute("name", "Jack"); //向reuqest域中添加一个属性
        req.getRequestDispatcher("IncludeTwoServlet").include(req,resp);
    }
}
