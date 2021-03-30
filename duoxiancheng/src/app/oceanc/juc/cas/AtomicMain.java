package app.oceanc.juc.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/29 10:37 下午
 * @Version 1.0
 */
public class AtomicMain {
    public static void main(String[] args) {
        try {
            Class unsafe = Unsafe.class;
            Field theUnsafe = unsafe.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe1 = (Unsafe) theUnsafe.get(null);
            long l = unsafe1.allocateMemory(100);
            System.out.println(l);
            unsafe1.freeMemory(l);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}