package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StudentService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String sgender = request.getParameter("sgender");
        int sage = Integer.parseInt(request.getParameter("sage"));
        float sheight = Float.parseFloat(request.getParameter("sheight"));
        Double sweight = Double.parseDouble(request.getParameter("sweight"));
        String saddress = request.getParameter("saddress");
        String sphone = request.getParameter("sphone");
        Student s = new Student(sid,sname,sgender,sage,sheight,sweight,saddress,sphone);
        StudentService service = new StudentService();
        int f = service.AddOne(s);

        if(f==1) {
            request.getRequestDispatcher("stuDao.jsp").forward(request, response);
        }
    }
}
