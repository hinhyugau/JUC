package app.oceanc.juc.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author bryan
 * @version 1.0
 * @description: doctor
 * @date 2021/3/30 9:44 下午
 */
public class CountDownLatchTaskDoctor implements Runnable {
    private CountDownLatch countDownLatch = null;

    public CountDownLatchTaskDoctor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("我是医生开始聊天!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}