package app.oceanc.juc.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/4/1 11:33 下午
 */
public class Client {
    public static void main(String[] args) {
        LockSupportLock lockSupportLock = new LockSupportLock();

        Thread t1 = new Thread(lockSupportLock);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 唤醒t1线程
        LockSupport.unpark(t1);
    }
}