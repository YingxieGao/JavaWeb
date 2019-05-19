import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Bservlet")
public class Bservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext app = this.getServletContext();
        Integer count = (Integer)app.getAttribute("count");
        if(count == null)
        {
            app.setAttribute("count",1);
        }
        else
        {
            app.setAttribute("count",count+1);
        }
        PrintWriter pw = resp.getWriter();
        pw.println(count);
    }
}
