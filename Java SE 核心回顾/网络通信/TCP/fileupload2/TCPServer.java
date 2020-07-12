package com.TCP.fileupload2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *   文件上传案例的服务器：读取客户端上传的文件，保存到文件的硬盘，给客户端写回上传成功
 *   明确：
 *      数据源：客户端上传的 文件
 *      目的地：服务器的硬盘 D:\\upload
 *   实现步骤:
 *  *       1、创建服务器ServerSocket对象和系统要指定的端口号
 *  *       2、使用ServerSocket对象的accept()方法，获取请求道的客户端Socket对象
 *  *       3、使用Socket对象中的方法getInputStream()方法获取网络字节输入流InputStream对象
 *          4、判断目的地文件夹是否存在，不存在则创建
 *          5、创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
 *  *       6、使用网络字节输入流的中的read()方法，读取客户端上传的文件
 *          7、使用本地字节输出流FileOutputStream对象中的write()方法，把读取到的文件保存到服务器的硬盘
 *  *       8、使用Socket对象中的getOutputStream()获取网络字节输出流的OutputStream对象
 *  *       9、使用网络字节输出流OutputStream对象的write()方法，给客户端写回上传成功
 *  *       10、关闭资源（Socket，ServerSocket， Socket）
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        /**
         *   让服务器一直处于监听状态（死循环accept）
         *   有一个客户端上传文件，就保存文件
         */

        while (true) {
            //2、使用ServerSocket对象的accept()方法，获取请求道的客户端Socket对象
            Socket socket = server.accept();

            /**
             *   使用多线程技术，提高程序效率
             *   有一个客户端上传文件，就开启一个线程，完成文件的上传
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3、使用Socket对象中的方法getInputStream()方法获取网络字节输入流InputStream对象
                        InputStream is = socket.getInputStream();
                        //4、判断目的地文件夹是否存在，不存在则创建
                        File file = new File("D:\\upload");
                        if (!file.exists()) {
                            file.mkdirs();
                        }


                        /**
                         *   自定义一个文件的命名规则：防止同名文件被覆盖
                         *   规则：域名+毫秒值+随机数
                         */
                        String fileName = "itcast" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";

                        //5、创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
                        //FileOutputStream fos = new FileOutputStream(file + "\\1.jpg");
                        FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);

                        //6、使用网络字节输入流的中的read()方法，读取客户端上传的文件
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1) {
                            //7、使用本地字节输出流FileOutputStream对象中的write()方法，把读取到的文件保存到服务器的硬盘
                            fos.write(bytes);
                        }
                        //8、使用Socket对象中的getOutputStream()获取网络字节输出流的OutputStream对象
                        OutputStream os = socket.getOutputStream();
                        //9、使用网络字节输出流OutputStream对象的write()方法，给客户端写回上传成功
                        os.write("上传成功".getBytes());
                        //10、关闭资源
                        socket.close();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        //此时服务器不用关闭
        //server.close();
    }
}

