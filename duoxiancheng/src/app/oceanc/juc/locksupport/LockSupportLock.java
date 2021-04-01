package app.oceanc.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/4/1 11:31 下午
 */
public class LockSupportLock implements Runnable {
    public static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count++;
            if (count == 5) {
                // 当前线程挂起
                LockSupport.park();
            }
            System.out.println(count);
        }
    }
}