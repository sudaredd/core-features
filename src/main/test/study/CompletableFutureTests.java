package study;


import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.delayedExecutor;

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

    @Test
    public void runsSync() {
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> {
            logger.info("sleeping");
            sleep(1);
        });

        Void join = runFuture.join();
        logger.info("result:" + join);
    }

    @Test
    public void supplyAsync() {
        CompletableFuture<String> runFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("sleeping");
            sleep(1);
            return "supplied async";
        });

        String join = runFuture.join();
        logger.info("result:" + join);
    }

    @Test
    public void completedThenRun() {
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("start")
                .thenRunAsync(() -> logger.debug("sleeping"), getDelayedExecutor(1))
                .thenRunAsync(() -> logger.debug("first run async"))
                .thenRunAsync(() -> logger.debug("second run async"))
                .thenRunAsync(() -> logger.debug("third run async"))
                .thenRunAsync(() -> logger.debug("fourth run async"));

        Void join = cf.join();
        logger.info("result:" + join);
    }

    @Test
    public void acceptEither() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture cf1 = new CompletableFuture();
        CompletableFuture cf2 = new CompletableFuture();

        CompletableFuture<Void> cfEither = cf1.acceptEitherAsync(cf2, logger::info, getDelayedExecutor(1));
        cf1.complete("cf1 completed");
        cf2.complete("cf2 completed");
        Void join = cfEither.get(2, TimeUnit.SECONDS);
        logger.info("finished");
    }


    @Test
    public void testCombine() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->"cf1 is complete", getDelayedExecutor(1));
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->"cf2 is complete", getDelayedExecutor(2));

        CompletableFuture<String> combined = cf1.thenCombine(cf2, (val1, val2)->val1 + ":"+val2);
        logger.debug("starting");
        String res = combined.join();
        logger.debug("result is :"+res);

    }

    @Test
    public void testCombineToList() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->"cf1 is complete", getDelayedExecutor(1));
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->"cf2 is complete", getDelayedExecutor(2));
        List<String> join = cf1.thenCombine(cf2, (val1, val2) -> Arrays.asList(val1, val2)).join();
        logger.info("result  "+ join);

    }

    @Test
    public void testAllOf() {
        CompletableFuture cf1 = new CompletableFuture();
        CompletableFuture cf2 = new CompletableFuture();
        CompletableFuture cf3 = new CompletableFuture();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(cf1, cf2, cf3)
                .thenRunAsync(() -> logger.debug("running1 after all done"), getDelayedExecutor(2))
                .thenRunAsync(() -> logger.debug("running2 after all done"), getDelayedExecutor(1));

        cf1.complete("cf1 is done");
        logger.debug("cf1 is done!!");

        cf2.complete("cf2 is done");
        logger.debug("cf2 is done!!");

        cf3.complete("cf3 is done");
        logger.debug("cf3 is done!!");


        logger.debug("starting to run allOf");
        Void res  = allOf.join();
        logger.debug("end all of");
    }

    private Executor getDelayedExecutor(int sec) {
        return delayedExecutor(sec, TimeUnit.SECONDS);
    }

    private void sleep(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            logger.error("error occured while sleeping ", e);
        }
    }
}
