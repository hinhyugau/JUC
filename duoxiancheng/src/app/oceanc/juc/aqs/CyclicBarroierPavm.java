package app.oceanc.juc.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/4/1 9:39 上午
 */
public class CyclicBarroierPavm {
    public static void main(String[] args) {
        //设置20个线程再执行下一个
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人发车!");
            }
        });
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}