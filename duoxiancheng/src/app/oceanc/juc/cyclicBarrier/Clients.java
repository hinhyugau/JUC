package app.oceanc.juc.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bryan
 * @version 1.0
 * @description:
 * @date 2021/4/1 4:37 下午
 */
public class Clients {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TourGuideTask());

        TravelTask changz = new TravelTask(cyclicBarrier, "厂长", 1);
        TravelTask uz = new TravelTask(cyclicBarrier, "uz", 2);
        TravelTask faker = new TravelTask(cyclicBarrier, "faker", 3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(changz);
        executorService.execute(uz);
        executorService.execute(faker);
    }
}
