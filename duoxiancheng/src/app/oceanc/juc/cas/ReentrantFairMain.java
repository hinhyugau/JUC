package app.oceanc.juc.cas;

/**
 * @author bryan
 * @version 1.0
 * @description: 公平锁运行
 * @date 2021/3/30 8:45 下午
 */
public class ReentrantFairMain {
    public static void main(String[] args) {
        ReentrantFair reentrantFair = new ReentrantFair();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    reentrantFair.fairMethod();
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    reentrantFair.fairMethod();
                }
            }
        };
        new Thread(r1, "r1").start();
        new Thread(r2, "r2").start();
    }
}
