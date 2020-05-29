package 网络通信;

import javafx.scene.layout.BorderRepeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receive extends JFrame implements Runnable, ActionListener {
    int port;
    InetAddress group = null;
    //创建多点广播套接字对象
    MulticastSocket socket = null;
    //创建按钮对象
    JButton ince = new JButton("开始接收");
    JButton stop = new JButton("停止接收");
    //显示接收广播的文本域
    JTextArea inceAr = new JTextArea(10,10);
    JTextArea inced = new JTextArea(10,10);
    //创建Thread对象
    Thread thread;
    //创建boolean类型变量
    boolean b = false;
    public Receive() {
        //调用父类方法
        super("广播数据报");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        thread = new Thread(this);
        //绑定ince按钮的单击事件
        ince.addActionListener(this);
        //绑定stop按钮的单击事件
        stop.addActionListener(this);
        //指定文本域中文字颜色
        inceAr.setForeground(Color.blue);
        //创建Jpanel对象
        JPanel north = new JPanel();
        //将按钮添加到面板上
        north.add(ince);
        north.add(stop);
        //将north放在窗体上部
        add(north,BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,2));
        //将文本域添加到到面板
        center.add(inceAr);
        center.add(inced);
        add(center, BorderLayout.CENTER);
        //刷新
        validate();
        port = 9898;
        try {
            //指定接收地址
            group = InetAddress.getByName("224.255.10.0");
            //绑定多点广播套接字
            socket = new MulticastSocket(port);
            //加入广播组
            socket.joinGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setBounds(100,50,360,380);
        setVisible(true);
    }
    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = null;
            //待接收的数据包
            packet = new DatagramPacket(data, data.length, group, port);
            try {
                //接收数据包
                socket.receive(packet);
                //获取数据包中的内容
                String message = new String(packet.getData(), 0, packet.getLength());
                //将接收内容显示在文本域中
                inceAr.setText("正在接收的内容：\n" + message);
                //每条信息为一行
                inced.setText(message + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (b == true) {
                break;
            }
        }
    }
    //点击事件
    public void actionPerformed(ActionEvent e) {
        //单击按钮ince触发的事件
        if (e.getSource() == ince) {
            //设置颜色按钮
            ince.setBackground(Color.red);
            stop.setBackground(Color.black);
            //如果线程不处于“新建状态”
            if (!(thread.isAlive())) {
                thread = new Thread(this);
            }
            thread.start();
            b = false;
        }
        //单击按钮stop触发的事件
        if (e.getSource() == stop) {
            //设置按钮颜色
            ince.setBackground(Color.yellow);
            stop.setBackground(Color.red);
            b = true;
        }
    }
    public static void main(String args[]) {
        Receive rec = new Receive();
        rec.setSize(460,200);
    }
}
