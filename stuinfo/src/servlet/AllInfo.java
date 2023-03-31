package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Student;
import service.StudentService;

/**
 * Servlet implementation class SearchInfo
 */
@WebServlet("/SearchInfo")
public class AllInfo extends HttpServlet {
    StudentService service = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> list = service.QueryAllStu();

        if(list!=null) {

            //把用户对象保存在session（会话控制）中，以便目标页面获取数据
            HttpSession session = request.getSession();
            session.setAttribute("all", list);
            //转到首页
            request.getRequestDispatcher("allInfo.jsp").forward(request, response);
        }
        else {

            request.getRequestDispatcher("error.jsp").forward(request, response);

        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
