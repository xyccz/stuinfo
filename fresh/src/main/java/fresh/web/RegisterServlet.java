package main.java.fresh.web;

import org.apache.commons.beanutils.BeanUtils;
import main.java.fresh.bean.User;
import main.java.fresh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user=new User();
        Map<String,String[]> stringMap =request.getParameterMap();
        try {
            //分别将属性设置到对象中
            // BeanUtils.setProperty(user,name,name);
            //将属性的map集合封装到对象中
            BeanUtils.populate(user,stringMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService=new UserService();

        // boolean register = userService.register(user);
        boolean register = userService.register(user);
        if (register) {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("注册失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}