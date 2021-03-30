package app.oceanc.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/29 10:35 下午
 * @Version 1.0
 */
public class AtomicThread {
    private AtomicInteger count = new AtomicInteger(0);

    public void getCount() {
        System.out.println(Thread.currentThread().getName() + "执行" + "数字为:" + count.incrementAndGet());
    }
}