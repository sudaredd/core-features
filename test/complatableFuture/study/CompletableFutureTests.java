package complatableFuture.study;


import core.socket.SocketServer;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTests {

    static private final org.apache.log4j.Logger logger = Logger.getLogger(CompletableFutureTests.class);

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
        try {
            CompletableFuture<String> cf = CompletableFuture.failedFuture(new RuntimeException("exception"));
            String result = cf.join();
            logger.info(result);
        } catch (RuntimeException e) {
            logger.error(e);
        }
    }

    @Test
    public void get() {

        logger.info("starting");
        CompletableFuture<String> cf = CompletableFuture.completedFuture("Completed test in Get");
        String result = null;
        try {
            result = cf.get();
        } catch (InterruptedException | ExecutionException e) {
           logger.error(String.valueOf(e));
        }
        logger.info(result);

    }

    @Test
    public void getFail() {

        logger.info("starting");
        CompletableFuture<String> cf = CompletableFuture.failedFuture(new RuntimeException("Failed test in Get"));
        String result = null;
        try {
            result = cf.get();
            logger.info(result);

        } catch (InterruptedException | ExecutionException e) {
            logger.error(String.valueOf(e));
        }
    }

    @Test
    public void obtrude() {

        logger.info("starting");
        CompletableFuture<String> cf = CompletableFuture.completedFuture("Completed test in obtrude");

        String result = cf.join();
        logger.info(result);

        cf.obtrudeValue("Override value on futures");
        result = cf.join();
        logger.info(result);

    }
}
