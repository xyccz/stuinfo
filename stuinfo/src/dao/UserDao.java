package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    QueryRunner queryRunner = new QueryRunner();

    /**
     * 检查此用户是否存在
     * @param userName
     * @return
     */
    public boolean checkUser(String userName) {
        String sql = "select userName from javaweb.user where userName=?";
        try {
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class), userName);
            if (user ==null) {
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
     * 注册用户
     * @param userName
     * @return
     */
    public boolean register(String userName, String password) {
        String sql="insert into javaweb.user values(null, ?, ?, null)";
        int affectedRow = -1;
        try {
            affectedRow = queryRunner.update(sql, userName, password);
            System.out.println(affectedRow > 0 ? "执行成功" : "执行失败");
            if (affectedRow > 0) {
                return  true;
            }else {
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User login(String userName, String password) throws SQLException {
        String sql="select * from user where name=? and password=?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), userName, password);
        return user;
    }
}
