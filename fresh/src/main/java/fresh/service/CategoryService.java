package main.java.fresh.service;

import main.java.fresh.bean.Category;
import main.java.fresh.bean.Page;
import main.java.fresh.dao.CategoryDao;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    CategoryDao dao = new CategoryDao();

    //添加
    public boolean addCategory(Category category) throws SQLException {
        boolean addCategory = dao.addCategory(category);
        return addCategory;
    }
    //查询
    public  List<Category> queryCategory() throws SQLException {
        List<Category> categories = dao.queryCategory();
        return categories;
    }
    //分页查询
    public Page findPageCategory(int currentPage, int currentCount) throws SQLException {
        Page page=new Page();
        // 1 查询出生鲜数据的总数
        int totalCount = dao.queryCount();
         /*  总数   每页显示数目  总页数
             9        10    0.9     1
             10       10     1      1
             11       10    1.1     2
            java ceil
         */
        // 2 根据总数和当前页显示数 计算出总页数
        int totalPage= (int) Math.ceil(1.0*totalCount/currentCount);
        //3 将分页相关信息封装到page类中
        page.setCurrentCount(currentCount);
        page.setCurrentPage(currentPage);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);

        // 计算查询的起始位置
//        页数  每页显示条数  起始位置
//
//        1        3           0
//        2        3           3
//        3        3           6  （currentPage-1）*currentCount
        //计算出起始位置
        int startPosition=(currentPage-1)*currentCount;
        // 分页查询数据
        List<Category> categories = dao.queryPageCategoryList(startPosition,currentCount);
        // 将集合数据封装到page类中
        page.setList(categories);
        return page;
    }
    //更新
    public boolean updateCategory(Category category) throws SQLException {
        boolean updateCategory = dao.updateCategory(category);
        return updateCategory;
    }
    //删除
    public boolean deleteCategory(Category category) throws SQLException {
        boolean updateCategory = dao.deleteCategory(category);
        return updateCategory;
    }
}