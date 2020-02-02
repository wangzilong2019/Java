package 多线程;

import java.time.chrono.ThaiBuddhistEra;
import java.util.SplittableRandom;

public class ThreadSafeTest implements Runnable {
    //设置当前总票数
    int count = 10;
    public void run() {
        while (true) {
            synchronized ("") {
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("tickets" + count--);
                }
            }
        }
    }
    public static void main(String args[]) {
        //实例化该类对象
        ThreadSafeTest t = new ThreadSafeTest();
        //以该类对象分别实例化四个线程
        Thread threadA = new Thread(t);
        Thread threadB = new Thread(t);
        Thread threadC = new Thread(t);
        Thread threadD = new Thread(t);
        //分别启动四个线程
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
