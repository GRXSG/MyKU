package Test;

import utill.JDBC_Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author
 * @Date 2022/1/18 10:20
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) throws SQLException {
        Connection con= JDBC_Util.getConnect();
        System.out.println(con);
    }



}
