import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;


@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Cookie c : req.getCookies()){
            if(c.getName().equals("user")){
                //String user = c.getValue();
                req.getSession().setAttribute("remember",true);
            }
            else{
                req.getSession().removeAttribute("remember");
            }

        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        User user= new User(userName, password);
        //Code to create new user if needed somewhere.
        //UserTable.getInstance().addUser(new User(userName, password));
        if(!userName.isEmpty() && !password.isEmpty() && UserTable.getInstance().getUserList().contains(user)){
        //if("ali".equals(userName) && "123".equals(password)){
            //create new session.
            req.getSession().setAttribute("user",userName);
            //Store user in cookie for a month.
            if("on".equals(remember)){
                Cookie cookie = new Cookie("user",userName);
                cookie.setMaxAge(3600*30);
                resp.addCookie(cookie);
            }
            else{
                //delete user cookie
                for(Cookie c : req.getCookies()){
                    if(c.getName().equals("user")){
                        c.setMaxAge(0);
                        resp.addCookie(c);
                    }
                }
            }

            //req.getRequestDispatcher("welcome.jsp").forward(req,resp);
            resp.sendRedirect("welcome.jsp");
        }
        else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
