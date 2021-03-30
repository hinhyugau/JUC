package app.oceanc.juc.cas;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bryan
 * @version 1.0
 * @description: 可重入锁ReentrantLock
 * @date 2021/3/30 5:00 下午
 */
public class ReentrantLock_01 {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void m1() {
        //加锁
        lock.lock();   //synchronized(this)
        try {
            System.out.println("当前线程为:" + Thread.currentThread().getName() + "变量为:" + count++);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    public void m2() {
        lock.tryLock();
    }
}