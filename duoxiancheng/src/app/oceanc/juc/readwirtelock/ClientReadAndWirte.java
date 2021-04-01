package app.oceanc.juc.readwirtelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/4/1 8:55 下午
 */
public class ClientReadAndWirte {
    public static void main(String[] args) {
       /* ReentrantLock reentrantLock = new ReentrantLock();
        ReadAndWirte readAndWirte = new ReadAndWirte(reentrantLock);
        new Thread(() -> {
            for (int i = 0; i < 18; i++) {
                readAndWirte.read();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                readAndWirte.wirte();
            }
        }).start();*/
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReadAndWirteLock readAndWirte = new ReadAndWirteLock(reentrantReadWriteLock);
        new Thread(() -> {
            for (int i = 0; i < 18; i++) {
                readAndWirte.read();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                readAndWirte.wirte();
            }
        }).start();
    }
}