package utill;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author wen
 * @Date 2022/1/17 20:41
 * @Version 1.0
 */
public class JDBC_Util {
    //驱动地址
    private static String dirverName =null;
    //数据库的url
    private static String url = null;
    //数据库的账号
    private static String username=null;
    //数据库的密码
    private static String password =null;
//数据库连接
    static {
        Properties ps =new Properties();
        try {
            ps.load(new FileInputStream("C:\\Users\\123\\AppData\\Roaming\\JetBrains\\IntelliJIdea2021.3\\scratches\\scratch_1.properties"));
            dirverName= ps.getProperty("driverName");
            url= ps.getProperty("url");
            username=ps.getProperty("username");
            password= ps.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    //数据库关闭
    public static void closeALL(Connection con, Statement sta, ResultSet rs){
        if (con !=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta !=null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
