package top.unclens.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取连接池对象
    public static DataSource getDataSource(){
        return dataSource;
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
