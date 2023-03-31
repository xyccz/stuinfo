package dao;

import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtilsByDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    private QueryRunner queryRunner = new QueryRunner();
    JdbcUtilsByDruid jdbcUtilsByDruid = new JdbcUtilsByDruid();

    /**
     * 查询所有学生信息
     * @return
     */
    public List<Student> QueryAll() {
        Connection connection =jdbcUtilsByDruid.getConnection();
        String sql = "SELECT r.row_num,s.* FROM javaweb.studata s,(SELECT name,ROW_NUMBER() OVER (ORDER BY name) row_num FROM javaweb.studata) r WHERE s.name = r.name AND row_num>=?";
        //query方法执行sql语句，得到resultset---封装到--->ArrayList结果集
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(Student.class),1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 指定学号查询学生的信息
     * @param id
     * @param name
     * @return
     */
    public Student QueryOne(String id, String name){
        Connection connection = jdbcUtilsByDruid.getConnection();

        String sql = "select * from javaweb.studata where ID=? and name=?";
        try {
            return queryRunner.query(connection, sql, new BeanHandler<>(Student.class),id, name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    public int AddOne(Student student) {
        int affectedRow = -1;
        Connection connection = jdbcUtilsByDruid.getConnection();
        String sql = "insert into javaweb.studata values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            //0为未修改成功，1修改成功
            affectedRow = queryRunner.update(connection, sql,student);
            System.out.println(affectedRow > 0 ? "执行成功" : "执行失败");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtilsByDruid.close(null, null, connection);
        }
        return affectedRow;
    }

    /**
     * 指定学号删除学生的信息
     * @param ID
     * @return
     */
    public int deleteOne(String ID) {
        int affectedRow = -1;
        PreparedStatement preparedStatement;
        Connection connection = jdbcUtilsByDruid.getConnection();
        String sql = "delete from javaweb.studata where ID = ?";

        try {
            affectedRow = queryRunner.update(connection, sql, ID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtilsByDruid.close(null, null, connection);
        }
        return affectedRow;
    }
}
