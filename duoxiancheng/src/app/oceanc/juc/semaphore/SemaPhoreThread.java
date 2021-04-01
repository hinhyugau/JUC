package app.oceanc.juc.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/4/1 9:33 下午
 */
public class SemaPhoreThread {
    public static void main(String[] args) {
        //允许一个线程
        Semaphore semaphore = new Semaphore(1);
        new Thread(() -> {
            try {
                //阻塞方法
                semaphore.acquire();
                System.out.println("T1 running");
                Thread.sleep(200);
                System.out.println("T1 running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();

        new Thread(() -> {
            try {
                //阻塞方法
                semaphore.acquire();
                System.out.println("T2 running");
                Thread.sleep(200);
                System.out.println("T2 running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
