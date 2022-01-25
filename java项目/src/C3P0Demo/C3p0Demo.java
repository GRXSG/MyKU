package C3P0Demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author
 * @Date 2022/1/18 19:47
 * @Version 1.0
 * comboPooledDataSource 有一个构造重载
 * ComboPooledDataSource（）读取的是默认配置项
 * ComboPooledDataSource（String configName):根据named-config命名读取对应的配置
 */
public class C3p0Demo {
    public static void main(String[] args) throws SQLException {
        sql2();
        ComboPooledDataSource cod =new ComboPooledDataSource();
        Connection connection = cod.getConnection();
       System.out.println(connection);
        connection.close();
    }
    //连接第二个数据库
    static void sql2() throws SQLException {
        ComboPooledDataSource cod =new ComboPooledDataSource("mysql");
        Connection connection = cod.getConnection();
        System.out.println(connection);
        connection.close();
    }



}
