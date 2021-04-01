package app.oceanc.juc.readwirtelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author bryan
 * @version 1.0
 * @description: 读写分离锁
 * @date 2021/4/1 9:02 下午
 */
public class ReadAndWirteLock implements Runnable {
    private ReentrantReadWriteLock lock = null;
    private static volatile int value = 1;

    private Lock readLock = null;
    private Lock wirtLock = null;

    public ReadAndWirteLock(ReentrantReadWriteLock lock) {
        this.lock = lock;
        this.readLock = lock.readLock();
        this.wirtLock = lock.writeLock();
    }

    @Override
    public void run() {

    }

    public void read() {
        readLock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("read over " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println("读取计数" + lock.getReadLockCount());
        }
    }

    public void wirte() {
        wirtLock.lock();
        try {
            value++;
            System.out.println("wirte over" + value);
        } finally {
            wirtLock.unlock();
            System.out.println("写入计数:" + lock.getWriteHoldCount());
        }
    }
}