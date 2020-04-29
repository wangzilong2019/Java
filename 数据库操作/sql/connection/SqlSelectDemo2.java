package sql.connection;

import java.io.IOException;
import java.sql.*;

public class SqlSelectDemo2 {
    public static void main (String args[]) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test" +
                    "?characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //设置登录用户名和密码
            String username = "root";
            String password = "142063qx";
            //连接数据库
            con = DriverManager.getConnection(url, username, password);

//            //插入数据操作
//            String sql1 = "insert into student values(?,?,?,?,?)";
//            ps = con.prepareStatement(sql1);
//            ps.setString(1, "003");
//            ps.setString(2, "张三");
//            ps.setString(3, "男");
//            ps.setInt(4, 30);
//            ps.setString(5, "纺织类");
//            ps.executeUpdate();

//            //删除数据
//            String sql2 = "delete from student where Sname ='张三'";
//            ps = con.prepareStatement(sql2);
//            ps.executeUpdate();

            //修改数据
            String sql3 = "update student set Sage = 30 where Sname = '周少龙'";
            ps = con.prepareStatement(sql3);
            ps.executeUpdate();

            //模糊查询语句
            String sql = "select * from student;";
            ps = con.prepareStatement(sql);
            //处理查询结果集
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String Sno = res.getString(1);
                String Sname = res.getString(2);
                String Ssex = res.getString(3);
                int Sage = res.getInt("Sage");
                String Sdept = res.getString("Sdept");
                System.out.println("Sno:" + Sno + "Sname:" + Sname + "Ssex:" + Ssex + "Sage:" + Sage + "Sdept:" + Sdept);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
