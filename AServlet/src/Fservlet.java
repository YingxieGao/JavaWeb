import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * 演示Request获取请求参数。
 */

@WebServlet("/Fservlet")
public class Fservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET: "+req.getParameter("xxx"));
        System.out.println("GET: "+req.getParameter("yyy"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println(username+", "+password + ", " + Arrays.toString(hobby));
        resp.getWriter().println(username+", "+password + ", " + Arrays.toString(hobby));

        Map<String,String[]> map = req.getParameterMap();
        for(String name : map.keySet())
        {
            String[] value = map.get(name);
            System.out.println(name + ": "+ Arrays.toString(value));
        }
    }
}
