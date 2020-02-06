package 数据库操作;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Train {
    //声明Connection类对象
    static Connection con;
    //声明Statement类对象
    static Statement sql;
    //声明ResultSet类对象
    static ResultSet res;
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
            con = DriverManager.getConnection("jdbc.mysql:" +
                    "//127.0.0.1:3306/test","root", "123456");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String args[]) {
        //创建本类对象
        Train c = new Train();
        //与数据连接
        con = c.getConnection();
        try {
            //实例化Statement对象
            sql = con.createStatement();
            //执行SQL语句，返回结果值
            res = sql.executeQuery("select","from tb_stu where" + "name like '张%'");
            //如果当前语句不是最后一条，进入循环
            while (res.next()) {
                //获取列名是id的字段值
                String id = res.getString("id");
                //获取列名是name的字段值
                String name = res.getString("name");
                //获取列名是sex的字段值
                String sex = res.getString("sex");
                //获取列名是birthday的字段名
                String birthday = res.getString("birthday");
                //将列值输出
                System.out.println("编号：" + id);
                System.out.println("姓名" + name);
                System.out.println("性别：" + sex);
                System.out.println("生日：" + birthday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
