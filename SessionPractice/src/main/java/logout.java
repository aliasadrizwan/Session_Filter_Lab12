import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //delete user cookie
        Cookie cookie = new Cookie("user",req.getSession().getAttribute("user").toString());
        cookie.setMaxAge(-10);
        resp.addCookie(cookie);
        //delete session
        req.getSession().invalidate();
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
