package Test;

import utill.JDBC_Util;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author
 * @Date 2022/1/18 11:12
 * @Version 1.0
 * 查询预编译
 */
public class Login {
    public static void main(String[] args) throws SQLException {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入账号：");
        String name=sc.next();
        System.out.println("请输入密码：");
        String password =sc.next();
        System.out.println(loginview(name,password)==true?"登陆成功":"登陆失败");

        select(name);
    }
    //预编译
    //登录
    public static boolean loginview(String name,String password) throws SQLException {
        Connection con = JDBC_Util.getConnect();
        PreparedStatement pre =con.prepareStatement("select * from student where username = ?AND password=?");
        pre.setString(1,name);
        pre.setString(2,password);
        ResultSet res = pre.executeQuery();
        return res.next();
    }
    //查询
    public static  void  select(String name) throws SQLException {
        Connection connection =JDBC_Util.getConnect();
        String sql = "select * from student where username = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,name);
        ResultSet res=pre.executeQuery();
        while (res.next()){
             name =res.getString("name");
            System.out.println(name);

        }
    }

}
