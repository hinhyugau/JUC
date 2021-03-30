package app.oceanc.juc.sync;

/**
 * @author bryan
 * @version 1.0
 * @description: 双重锁机制
 * @date 2021/3/30 3:52 下午
 */
public class Singleton {
    /**
     * volatile保证了线程可见行,禁止指令重排序
     */
    private volatile static Singleton singleton;

    /**
     * 私有构造方法
     */
    private Singleton() {
    }

    /**
     * 静态方法获取对象
     */
    public static Singleton getSingletonInstance() {
        // 当对象为null进入
        if (null == singleton) {
            /**
             * 代码段加锁 粒度越细效率越高
             * synchronized保证了原子性也保证了可见性,但是不能禁止指令冲排序
             */
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}