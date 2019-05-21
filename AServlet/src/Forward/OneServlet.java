package Forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 */
@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("aaa", "AAA");//设置响应头
        resp.getWriter().println("I am OneServlet response body, you cannot see me");
        req.setAttribute("name", "Jack"); //向reuqest域中添加一个属性
        req.getRequestDispatcher("TwoServlet").forward(req,resp);
    }
}
