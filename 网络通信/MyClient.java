package 网络通信;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient  extends JFrame {
    //声明各类对象
    private PrintWriter printWriter;
    Socket socket;
    private JTextArea jTextArea = new JTextArea();
    private JTextField jTextField = new JTextField();
    Container cc;
    public MyClient(String title) {
        //调用父类构造方法
        super(title);
        //实例化对象
        cc = this.getContentPane();
        final JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jScrollPane,BorderLayout.CENTER);
        jScrollPane.setViewportView(jTextArea);
        //将文本框放在窗体的最下部
        cc.add(jTextField,"South");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTextField.addActionListener(new ActionListener() {
            //绑定事件
            public void actionPerformed(ActionEvent e) {
                //将本文框的信息写入流
                printWriter.println(jTextField.getText());
                //将文本框的信息显示在文本域中
                jTextArea.append(jTextField.getText() + "\n");
                jTextArea.setSelectionEnd(jTextArea.getText().length());
                //将文本框清空
                jTextField.setText("");
            }
        });
    }
    //连接套接字的方法
    private void connect() {
        //文本域中提示信息
        jTextArea.append("尝试连接\n");
        try {
            //实例化Socket类对象
            socket = new Socket("127.0.0.1",8998);
            printWriter = new PrintWriter(socket.getOutputStream(),true);
            //文本域中提示信息
            jTextArea.append("完成连接\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        MyClient myClient = new MyClient("向服务器送数据");
        myClient.setSize(200,200);
        myClient.setVisible(true);
        myClient.connect();
    }
}
