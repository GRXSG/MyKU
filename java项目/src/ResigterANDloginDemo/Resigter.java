package ResigterANDloginDemo;

import utill.JDBC_Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author
 * @Date 2022/1/18 15:33
 * @Version 1.0
 */
public class Resigter {
    //注册
    public static void resigter(String name ,String password) throws SQLException {
        Connection con = JDBC_Util.getConnect();
        String sql = "INSERT INTO student VALUES (?, ?);";
        PreparedStatement pre =con.prepareStatement(sql);
        pre.setString(1,name);
        pre.setString(2,password);
        int in = pre.executeUpdate();
        System.out.println(in>=1?"注册成功":"注册失败");
    }
    //登录
    public static boolean loginview(String name,String password) throws SQLException {
        Connection con = JDBC_Util.getConnect();
        PreparedStatement pre =con.prepareStatement("select * from student where username = ?AND password=?");
        pre.setString(1,name);
        pre.setString(2,password);
        ResultSet res = pre.executeQuery();
        return res.next();

    }
    //查表
    static void search(int id) throws SQLException {
        Connection con = JDBC_Util.getConnect();
        PreparedStatement pre = con.prepareStatement("select * from student where username= ?;");
        pre.setInt(1,id);;
        ResultSet res =pre.executeQuery();
        while (res.next()){
            String name=res.getString("username");
            String password = res.getString("password");
            System.out.println(name+":"+password);
        }
    }
    //删除
    static  void  Delete(String username) throws SQLException {
        Connection con = JDBC_Util.getConnect();
        PreparedStatement pre = con.prepareStatement("delete from student where username=?;");
        pre.setString(1,username);
        int count = pre.executeUpdate();
        System.out.println(count>=0?"删除成功":"删除失败");
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择：");
        int select = sc.nextInt();
        if (select==1){
            System.out.println("注册账号");
            String n = sc.next();
            System.out.println("注册密码");
            String p = sc.next();
            Resigter.resigter(n,p);
        }
        else {
            System.out.println("登陆账号");
            String n = sc.next();
            System.out.println("登录密码");
            String p = sc.next();
            System.out.println(Resigter.loginview(n,p)==true?"登陆成功":"登录失败");
            int id = sc.nextInt();
            Resigter.search(id);
            System.out.println("删除数据输入：");
            String s = sc.next();
            Resigter.Delete(s);

        }

    }
}
