package app.oceanc.juc.cas;

import java.util.concurrent.TimeUnit;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/3/30 5:05 下午
 */
public class ReentrantLock_01_main {
    public static void main(String[] args) {
        ReentrantLock_01 reentrantLock_01 = new ReentrantLock_01();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantLock_01.m1();
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantLock_01.m1();
                }
            }
        };
        Runnable r3 = new Runnable() {
            @Override
            public void run() {

                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                reentrantLock_01.m2();
            }
        };

        //new Thread(r1, "r1").start();
        // new Thread(r2, "r2").start();
        new Thread(r3).start();
    }
}
