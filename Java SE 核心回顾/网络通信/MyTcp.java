package 网络通信;

import 输入输出.MyZip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {
    //创建BufferedReader类对象
    private BufferedReader reader;
    //创建ServerSocket类对象
    private ServerSocket serverSocket;
    //创建Socket对象
    private Socket socket;
    void getserver() {
        try {
            //实例化ServerSocket类对象
            serverSocket = new ServerSocket(8998);
            System.out.println("服务器套接字已创建成功");
            //如果套接字是连续状态的
            while (true) {
                System.out.println("等待客户机的连接");
                //实例化Socket类对象
                socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getClientMessage() {
        try {
            //如果客户机是连接状态
            while (true) {
                //获取客户信息
                System.out.println("客户机:" + reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //关闭流和套接字
            if (reader != null) {
                reader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        //实例化本类对象
        MyTcp myTcp = new MyTcp();
        myTcp.getserver();
    }

}
