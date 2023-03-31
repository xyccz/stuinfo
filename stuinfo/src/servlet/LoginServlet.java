package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.Student;
import service.StudentService;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    StudentService service = new StudentService();
    UserService service1 = new UserService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单数据
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User u = service1.userLogin(name, password);
        System.out.println(u);
        if(u!=null) {
            request.getRequestDispatcher("userIndex.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
