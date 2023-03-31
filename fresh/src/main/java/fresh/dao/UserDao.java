package main.java.fresh.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import main.java.fresh.bean.User;

import java.sql.SQLException;

public class UserDao {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner queryRunner = new QueryRunner(dataSource);
    /**
     * 检查用户是否存在
     * @param name
     * @return
     */
    public boolean checkUser(String name){
        try {
            String sql="select name from user where name=?";
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class),name);
            //如果没有查询到数据 说明这个用户名没有注册过
            if (user==null) {
                return  true;
            }else {
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }

    }

    /**
     * 用户注册
     * @param
     * @return
     */
    public boolean register(String name,String password,String email) {
        try {
            String sql="insert into user values(null,?,?,?)";
            int row = queryRunner.update(sql, name,password, email);
            //行数大于零说明注册成功
            if (row>0) {
                return  true;
            }else {
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }

    }

    /**
     * 用户登录
     */
    public User login(String name, String password) throws SQLException {
        String sql="select * from user where name=? and password=?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class),name,password);
        return  user;
    }
}