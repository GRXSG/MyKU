package DruidPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author
 * @Date 2022/1/18 21:06
 * @Version 1.0
 */
public class DruidPoolDemo {
    public static void main(String[] args) throws Exception {
        Properties ps = new Properties();
        InputStream is = DruidPoolDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        ps.load(is);
        //获取连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(ps);
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        for (int i = 0; i <=10 ; i++) {
            Connection con = ds.getConnection();
            System.out.println(i+" "+conn);
        }
        conn.close();
    }
}
