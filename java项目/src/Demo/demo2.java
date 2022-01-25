package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author
 * @Date 2022/1/17 19:48
 * @Version 1.0
 */
public class demo2 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1","root","5201314");
        Statement sta = con.createStatement();
        String sql = "CREATE TABLE teahcer(id INT ,name VARCHAR(20));";
        int count =sta.executeUpdate(sql);
        System.out.println(count>0 ? "插入成功":"插入失败");
        sta.close();
        con.close();
    }
}
