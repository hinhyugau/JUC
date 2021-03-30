package app.oceanc.juc.cas;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bryan
 * @version 1.0
 * @description: 公平锁
 * @date 2021/3/30 8:41 下午
 */
public class ReentrantFair {
    private final Lock lock = new ReentrantLock();
    private static int count = 0;

    public void fairMethod() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + "获得锁!");
        } finally {
            lock.unlock();
        }
    }
}
