package app.oceanc.juc.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/3/30 9:50 下午
 */
public class CountDownLatchTaskPavm {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        CountDownLatchTaskDoctor countDownLatchTaskDoctor = new CountDownLatchTaskDoctor(countDownLatch);
        CountDownLatchTaskPerson countDownLatchTaskPerson = new CountDownLatchTaskPerson(countDownLatch);
        long start = System.currentTimeMillis();
        new Thread(countDownLatchTaskDoctor).start();
        new Thread(countDownLatchTaskPerson).start();
        long end = System.currentTimeMillis();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("回家执行时常为:" + (end - start));
    }
}