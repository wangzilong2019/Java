package 数据库操作;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Prep {
    //声明各类对象
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    //与数据库连接的方法
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection("jdbc:mysql:" +
                    "//127.0.0.1:3306/test","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String args[]) {
        //创建本类对象
        Prep c = new Prep();
        //获取与数据库的连接
        con = c.getConnection();
        try {
            //实例化与处理对象
            sql = con.prepareStatement("select * from table_name " +
                    " where id = ?");
            //设置参数
            sql.setInt(1, 19);
            //执行预处理语句
            res = sql.executeQuery();
            //如果当前记录不是聚合集中的最后一行，则进入循环体
            while (res.next()) {
                //获取结果列中第一列的值
                String id = res.getString(1);
                //获取name、sex、birthday的列值
                String name = res.getString("name");
                String sex = res.getString("sex");
                String birthday = res.getString("birthday");
                //输出信息
                System.out.println("编号：" + id);
                System.out.println("姓名：" + name);
                System.out.println("性别：" + sex);
                System.out.println("生日：" + birthday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
