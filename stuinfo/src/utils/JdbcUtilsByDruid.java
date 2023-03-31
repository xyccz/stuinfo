package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;


public class JdbcUtilsByDruid {
    private static DataSource ds;

    //properties方法
    /*public Properties seatProperties(String name) {
        URL url = this.getClass().getClassLoader().getResource(name);
        InputStreamReader inputStreamReader = null;
        Properties properties = new Properties();
        try {
            assert url != null;
            InputStream inputStream = url.openStream();
            inputStreamReader = new InputStreamReader(inputStream);
            //加载配置文件;
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }*/

    //获取properties属性
    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            //1.将编译异常转成运行异常
            //2.调用者可以选择捕获或者默认处理，比较方便
            throw new RuntimeException(e);
        }
    }

    //关闭连接，连接池中close不是真正的断掉连接，而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        //判断是否为空
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
