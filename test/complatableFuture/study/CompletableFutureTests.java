package complatableFuture.study;


import core.socket.SocketServer;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTests {

    static private final org.apache.log4j.Logger logger = Logger.getLogger(SocketServer.class);

    @Test
    public void join() {

        logger.info("starting");
        CompletableFuture<String> cf = CompletableFuture.completedFuture("Completed test");
        String result = cf.join();
        logger.info(result);

    }

    @Test
    public void joinFail() {

        logger.info("starting");
        CompletableFuture<String> cf = CompletableFuture.failedFuture(new RuntimeException("exception"));
        String result = cf.join();
        logger.info(result);

    }
}
