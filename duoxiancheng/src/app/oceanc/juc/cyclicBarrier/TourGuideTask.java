package app.oceanc.juc.cyclicBarrier;

/**
 * @author bryan
 * @version 1.0
 * @description: 导游线程
 * @date 2021/4/1 4:36 下午
 */
public class TourGuideTask implements Runnable {
    @Override
    public void run() {
        System.out.println("****导游分发护照签证****");
        try {
            //模拟发护照签证需要2秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}