package app.oceanc.juc.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author bryan
 * @version 1.0
 * @description: Person
 * @date 2021/3/30 9:48 下午
 */
public class CountDownLatchTaskPerson implements Runnable {
    private CountDownLatch countDownLatch = null;

    public CountDownLatchTaskPerson(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("人们聊天!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}