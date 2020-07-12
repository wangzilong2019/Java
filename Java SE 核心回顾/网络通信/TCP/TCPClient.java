package com.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *   TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，接收服务器回写的数据
 *   表示客户端的类：
 *       java.net.Socket;此类实现客户端套接字（）。套接字是俩台机器之间通信的节点
 *       套接字：包含了IP地址和端口号的网络单位
 *   构造方法：
 *       Socket(String host, int port) 创建一个套接字并将其连接到指定主机的指定端口号
 *       参数：
 *           host：服务器主机名称/IP地址
 *           port：服务器端口号
 *   成员方法：
 *       OutputStream getOutputStream()  返回此套接字的输出流
 *       InputStream getInputStream()  返回此套接字的输入流
 *    实现步骤：
 *       1、创建一个客户端Socket对象，参数绑定服务器的IP地址和端口号
 *       2、使用Socket对象中的getOutputStream()获取网络字节输出流的OutputStream对象
 *       3、使用网络字节输出流OutputStream对象的write()方法，向服务器发送数据
 *       4、使用Socket对象中的方法getInputStream()方法获取网络字节输入流InputStream对象
 *       5、使用网络字节输入流的中的read()方法，读取服务器回写的数据
 *       6、关闭资源
 *    注意：
 *       1、客户端和服务器进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
 *       2、当我们创建客户端对象Socket的时候，就会去请求服务器和服务器建立三次握手建立通路
 *           如果这时候服务器没有启动，就会抛出异常
 *           如果服务器已经启动，则进行交互
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //2、使用Socket对象中的getOutputStream()获取网络字节输出流的OutputStream对象
        OutputStream os = socket.getOutputStream();
        //3、使用网络字节输出流OutputStream对象的write()方法，向服务器发送数据
        os.write("你好服务器".getBytes());
        //4、使用Socket对象中的方法getInputStream()方法获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //5、使用网络字节输入流的中的read()方法，读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //6、关闭资源
        socket.close();
    }
}
