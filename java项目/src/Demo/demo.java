package Demo;

import java.sql.*;

public class demo {
    public static void main(String[] args) throws SQLException {
        Driver diver = new com.mysql.cj.jdbc.Driver();
        Connection conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1","root","5201314");
        Statement sta =conn.createStatement();
        ResultSet res = sta.executeQuery("select  * from student");
        while (res.next()){
            Object obj=res.getObject("name");
            System.out.println(obj);
        }
        res.close();
        sta.close();
        conn.close();
    }
}
