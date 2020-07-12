package com.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *   TCP通信的服务器端：接收客户端发送的请求，接收客户端发送的数据，给客户端回写数据
 *   表示服务器的类:
 *       java.net.ServerSocket；  此类实现服务器套接字
 *   构造方法：
 *       ServerSocket(int port)
 *           创建绑定到特定端口的服务器套接字。
 *   注意：
 *      服务器端必须知道哪个客户端请求的服务器
 *      所以可以使用accept()方法获取请求的Socket对象
 *   特有成员方法
 *      Socket accept()
 *           侦听并接受到此套接字的连接。
 *    实现步骤：
 *       1、创建服务器ServerSocket对象和系统要指定的端口号
 *       2、使用ServerSocket对象的accept()方法，获取请求道的客户端Socket对象
 *       3、使用Socket对象中的方法getInputStream()方法获取网络字节输入流InputStream对象
 *       4、使用网络字节输入流的中的read()方法，读取客户端发送的数据
 *       5、使用Socket对象中的getOutputStream()获取网络字节输出流的OutputStream对象
 *       6、使用网络字节输出流OutputStream对象的write()方法，给客户端写数据
 *       7、关闭资源（Socket，ServerSocket）
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //2、使用ServerSocket对象的accept()方法，获取请求道的客户端Socket对象
        Socket socket = server.accept();
        //3、使用Socket对象中的方法getInputStream()方法获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //4、使用网络字节输入流的中的read()方法，读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //5、使用Socket对象中的getOutputStream()获取网络字节输出流的OutputStream对象
        OutputStream os = socket.getOutputStream();
        os.write("收到谢谢".getBytes());
        socket.close();
        server.close();
    }
}
