package 多线程;

public class ThreadSafeTest_02 implements Runnable{
    int count = 10;
    public synchronized void doit() {
        if (count > 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("tickets" + --count);
        }
    }
    public void run() {
        while (true) {
            doit();
        }
    }
    public static void main(String args[]) {
        //实例化该类对象
        ThreadSafeTest_02 t = new ThreadSafeTest_02();
        //将该对象实例化四个线程
        Thread threadA = new Thread(t);
        Thread threadB = new Thread(t);
        Thread threadC = new Thread(t);
        Thread threadD = new Thread(t);
        //启动线程
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
