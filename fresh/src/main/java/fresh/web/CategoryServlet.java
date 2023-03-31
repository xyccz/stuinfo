package main.java.fresh.web;

import org.apache.commons.beanutils.BeanUtils;
import main.java.fresh.bean.Category;
import main.java.fresh.bean.Page;
import main.java.fresh.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {
    Category category = new Category();
    CategoryService service=new CategoryService();
    //添加
    public void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数 通过BeanUtils封装实体类
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            category.setCreatetime(new Date());
            BeanUtils.populate(category,parameterMap);
            boolean b = service.addCategory(category);
            if (b){
                //添加成功
                response.setStatus(201);
                request.getRequestDispatcher("/category-add.jsp").forward(request,response);
            }else {
                // 添加失败
                response.setStatus(600);
                request.getRequestDispatcher("/category-add.jsp").forward(request,response);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询
   /* public void queryCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 调用service中的查询方法
        try {
            CategoryService service=new CategoryService();
            List<Category> categoryList = service.queryCategory();
            if ( categoryList!=null&&categoryList.size()>0) {
                request.setAttribute("list",categoryList);
                request.getRequestDispatcher("/category-list.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("/category-list.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    //分页查询
    public void queryCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 调用service中的查询方法

        try {
            String tmp=request.getParameter("currentPage");
            String tmp1=request.getParameter("currentCount");
            int currentPage = Integer.parseInt(tmp);//当前页
            int currentCount = Integer.parseInt(tmp1);//当前总数
            //没参数设置为第一页
          /*  if (tmp.equals("null")||tmp.equals("null")){
                currentCount=5;
                currentPage=1;
            }else {*/
            // 给分页数据设置默认值
            if (currentCount==0){
                currentCount=5;
            }
            if (currentPage==0){
                currentPage=1;
            }
            /*  }*/
            CategoryService service=new CategoryService();
            Page page = service.findPageCategory(currentPage, currentCount);
            if (page!=null) {
                request.setAttribute("page",page);
                request.getRequestDispatcher("/category-list.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("/category-list.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //修改
    public void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1 调用service中的查询方法
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(category,parameterMap);
            boolean updateCategory = service.updateCategory(category);

            if (updateCategory){
                // 修改成功后重定向到生鲜列表界面
                response.sendRedirect(request.getContextPath()+"/category?method=queryCategoryList&currentPage=1&currentCount=5");

            }else {
                // 失败了直接提示
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("修改失败");
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除
    public void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1 调用service中的查询方法
            Map<String, String[]> parameterMap = request.getParameterMap();
            Category category=new Category();
            BeanUtils.populate(category,parameterMap);
            CategoryService service=new CategoryService();
            boolean updateCategory = service.deleteCategory(category);

            if (updateCategory){
                // 删除成功后重定向到生鲜列表界面
                response.sendRedirect(request.getContextPath()+"/category?method=queryCategoryList&currentPage=1&currentCount=5");

            }else {
                // 失败了直接提示
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("删除失败");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}