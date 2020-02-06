package 数据库操作;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    //声明Connection对象
    Connection conn;
    public Connection getConnection() {
        //加载数据库驱动类
        try {
            Class.forName("com.myaql.jbdc.Driver");
            System.out.println("数据库加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //通过访问数据库的URL，获取数据库连接对象
        try {
            conn = DriverManager.getConnection("jdbc.mysql:" +
                    "//127.0.0.1:3306/test","root", "123456");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String args[]) {
        Conn c = new Conn();
        c.getConnection();
    }
}
