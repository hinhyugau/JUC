package app.oceanc.juc.readwirtelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author bryan
 * @version 1.0
 * @description:  普通的锁
 * @date 2021/4/1 8:50 下午
 */
public class ReadAndWirte implements Runnable {
    private Lock lock = null;
    private static int value = 1;

    public ReadAndWirte(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

    }

    public void read() {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("read over " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void wirte() {
        lock.lock();
        try {
            value++;
            System.out.println("wirte over" + value);
        } finally {
            lock.unlock();
        }
    }
}