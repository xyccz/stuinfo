package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserService();

        request.setCharacterEncoding("utf-8");

        //获取表单数据
        String name = request.getParameter("uname");
        String password = request.getParameter("upassword");
        String role = request.getParameter("role");
        boolean f = false;
        f = service.register(name, password);
        if(f) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
