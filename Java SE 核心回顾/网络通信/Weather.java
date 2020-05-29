package 网络通信;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Weather extends Thread{
    String weather = "节目预报：八点有大型晚会，请收听";
    //定义端口
    int port = 9898;
    //创建InetAddress类对象
    InetAddress inetAddress = null;
    //声明多点广播套接字
    MulticastSocket socket = null;
    Weather() {
        try {
            //实例化InetAddress，指定地址
            inetAddress = InetAddress.getByName("224.255.10.0");
            //实例化多点字广播套接字
            socket = new MulticastSocket(port);
            //指定发送范围的本地网络
            socket.setTimeToLive(1);
            //加入广播组
            socket.joinGroup(inetAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        while (true) {
            //声明DatagramPacket对象
            DatagramPacket packet = null;
            //声明字节数
            byte[] data = weather.getBytes();
            //将数据包打印
            packet = new DatagramPacket(data, data.length, inetAddress, port);
            //将广播信息输出
            System.out.println(new String(data));
            try {
                //发送数据
                socket.send(packet);
                sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        Weather w = new Weather();
        w.start();
    }
}
