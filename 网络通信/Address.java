package 网络通信;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Address {
    public static void main(String args[]) {
        //创建InetAddress类对象
        InetAddress ip;
        try {
            //实例化该类对象
            ip = InetAddress.getLocalHost();
            //获取本机名与IP地址
            String localname  = ip.getHostName();
            String loacalip = ip.getHostAddress();
            System.out.println("本机名" + localname);
            System.out.println("本机IP地址" + loacalip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
