package sql.connection;

import java.sql.*;

public class SqlConnection {
    public static void main (String args[]) {
        Connection con = null;
        Statement sql = null;
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test" +
                    "?characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String username = "root";
            String password = "142063qx";
            //获取数据库的连接对象
            con = DriverManager.getConnection(url, username, password);
            //创建Statement对象用来向数据库发送SQL 语句
            sql = con.createStatement();

//            //查询数据库
//            //处理查询结果集


//            //向数据库中添加数据
//            String sql1 = "insert into student values('003', '高宁波','男', 22, '土木工程')";
//            int result = sql.executeUpdate(sql1);

//            //跟新数据库中记录
//            String sql2 = "update student set Sdept = '管理类' where Sname = '高宁波'";
//            int result = sql.executeUpdate(sql2);

            //删除记录
            String sql3 = "delete from student where Sno = '003'";
            int result = sql.executeUpdate(sql3);

            ResultSet res = sql.executeQuery("select * from student"); //此处可以省略;
            while (res.next()) {
                String Sno = res.getString(1);
                String Sname = res.getString(2);
                String Ssex = res.getString(3);
                int Sage = res.getInt("Sage");
                String Sdept = res.getString("Sdept");
                System.out.println("Sno:" + Sno + "Sname:" + Sname + "Ssex:" + Ssex + "Sage:" + Sage + "Sdept:" + Sdept);
            }
            System.out.println(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sql != null) {
                try {
                    sql.close();
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
