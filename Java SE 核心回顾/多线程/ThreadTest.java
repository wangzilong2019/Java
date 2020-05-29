package 多线程;

public class ThreadTest extends Thread {
    private int count = 10;
    //重写run()方法
    public void run() {
        while (true) {
            System.out.println(count + " ");
            if (--count == 0) {
                return;
            }
        }
    }
    public static void main(String args[]) {
        new ThreadTest().start();
    }
}
