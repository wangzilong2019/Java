package com.TCP.fileupload2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *    文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据
 *    明确：
 *       数据源：D:\\a.txt
 *       目的地：服务器
 *    实现步骤：
 *       1、创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
 *       2、创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
 *       3、使用Socket中的getOutputStream方法，获取网络字节输出流OutputStream对象
 *       4、使用本地字节输入流FileInputStream中的read()方法，读取本地文件
 *       5、使用网络字节输出流OutputStream中的方法write()，把读取到的文件上传到服务器
 *       6、使用Socket中的getInputStream方法，获取网络字节输出流InputStream对象
 *       7、使用网络字节输入流InputStream中的read()方法，读取服务器写回的数据
 *       8、释放资源(FileInputStream, socket)
 *
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\b.jpg");
        //2、创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //3、使用Socket中的getOutputStream方法，获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //4、使用本地字节输入流FileInputStream中的read()方法，读取本地文件
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            //5、使用网络字节输出流OutputStream中的方法write()，把读取到的文件上传到服务器
            os.write(bytes);
        }

        /**
         *    解决：上传完文件，给文件写一个结束标记
         *        void shutdownOutput() 禁用此套接字的输出流
         *        对于TCP套接字，任何以前写入的数据都将被发送，并且后跟TCP的正常连接终止序列
         */
        socket.shutdownOutput();

        //6、使用Socket中的getInputStream方法，获取网络字节输出流InputStream对象
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1) {
            //7、使用网络字节输入流InputStream中的read()方法，读取服务器写回的数据
            System.out.println(new String(bytes, 0, len));
        }
        //8、关闭资源
        fis.close();
        socket.close();
    }
}
