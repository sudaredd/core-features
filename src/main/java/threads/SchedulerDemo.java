package threads;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SchedulerDemo {

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(4);

    public static void main(String[] args) {
        var startAfter = 300000;
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
//        ScheduledFuture startScheduler = SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(() -> stopRoundWorker(), 0, startAfter, TimeUnit.MILLISECONDS);
    }

    private static Object stopRoundWorker() {
        System.out.println("Running at "+LocalDateTime.now());
        return "SUCCESS";
    }
}
