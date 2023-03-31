package main.java.fresh.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import main.java.fresh.bean.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner queryRunner = new QueryRunner(dataSource);
    //添加
    public boolean  addCategory(Category category) throws SQLException {
        String sql="insert into category values(null,?,?,?,?)";
        int row = queryRunner.update(sql, category.getC_name(), category.getPlace(), category.getCreatetime(), category.getType());
        if (row>0){
            return true;
        }else {
            return false;
        }

    }
    //查询
    public List<Category> queryCategory() throws SQLException {
        String sql="select * from category";
        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        return categoryList;
    }
    //查询列表总数
    public int queryCount() throws SQLException {
        String sql="select count(*) from category";
        Long query = queryRunner.query(sql, new ScalarHandler<>());
        return query.intValue();
    }
    //分页查询
    public List<Category> queryPageCategoryList(int startPosition, int currentCount) throws SQLException {
        String sql="select * from category limit ?,?";
        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class),startPosition,currentCount);
        return categoryList;
    }
    //更新
    public boolean updateCategory(Category category) throws SQLException {
        String sql="update category set c_name=?,place=?,type=? where c_id=?";
        int row = queryRunner.update(sql, category.getC_name(), category.getPlace(), category.getType(),category.getC_id());
        if (row>0){
            return true;
        }else {
            return false;
        }
    }
    //删除
    public boolean deleteCategory(Category category) throws SQLException {
        String sql="delete from category where c_id=?";
        int row = queryRunner.update(sql,category.getC_id());
        return row>0?true:false;
    }
}