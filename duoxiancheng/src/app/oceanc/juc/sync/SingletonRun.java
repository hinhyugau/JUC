package app.oceanc.juc.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/3/30 4:06 下午
 */
public class SingletonRun {
    public static void main(String[] args) {
        Singleton singletonInstance = Singleton.getSingletonInstance();
        Runnable sin1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        System.out.println(e.getLocalizedMessage());
                    }
                    System.out.println(singletonInstance);
                }
            }
        };

        Runnable sin2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        System.out.println(e.getLocalizedMessage());
                    }
                    System.out.println(singletonInstance);
                }
            }
        };

        new Thread(sin1).start();
        new Thread(sin2).start();
    }
}