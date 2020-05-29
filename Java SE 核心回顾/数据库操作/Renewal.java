package 数据库操作;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Renewal {
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
        //实例化本类对象
        Renewal c = new Renewal();
        //调用连接数据库的方法
        con = c.getConnection();
        try {
            //查询数据库
            sql = con.prepareStatement("select * from tb_stu");
            //执行SQL语句
            res = sql.executeQuery();
            System.out.println("执行添加、修改、删除操作之前的数据");
            while (res.next()) {
                String id = res.getString("1");
                String name = res.getString("name");
                String sex = res.getString("sex");
                String birthday = res.getString("birthday");
                System.out.println("编号：" + id);
                System.out.println("姓名：" + name);
                System.out.println("性别：" + sex);
                System.out.println("生日：" + birthday);
            }
            //预处理添加数据
            sql = con.prepareStatement("insert into tb_stu" + "values(?,?,?)");
            sql.setString(1,"张一");
            sql.setString(2,"女");
            sql.setString(3,"2012-12-1");
            sql.executeUpdate();
            //更新数据信息
            sql = con.prepareStatement("update tb_stu birthday" +
                    "=? where id = (select min(id) from tb_stu)");
            sql.setString(1,"2012-12-02");
            sql.executeUpdate();
            //删除数据
            sql.executeUpdate("delete from tb_stu where id = " +
                    "(select min(id)from tb_stu)");
            sql.setInt(1,1);
            sql.executeUpdate();
            //查询修改数据后tb_stu表中的数据
            sql = con.prepareStatement("select * from tb_stu");
            //执行SQL语句
            res = sql.executeQuery();
            System.out.println("执行增加、修改、删除后的数据");
            while (res.next()) {
                String id = res.getString("1");
                String name = res.getString("name");
                String sex = res.getString("sex");
                String birthday = res.getString("birthday");
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
