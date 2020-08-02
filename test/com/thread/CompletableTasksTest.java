package com.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompletableTasksTest {


    //Simple completed
    @Test
    public void testSimpleCompletedFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completed = CompletableFuture.completedFuture("done");
        assertTrue(completed.isDone());
        assertEquals("done", completed.get());
    }

    //Run sync
    @Test
    public void testSimpleRunSync() {
        DataHolder<Integer> holder = new DataHolder<>();
        CompletableFuture<Void> runAsyncFut = CompletableFuture.runAsync(() -> setVal(holder));
        runAsyncFut.join();
        int i = holder.getVal();
        assertEquals(10, i);
    }

    //supply Async
    @Test
    public void testSupplyAsync() throws ExecutionException, InterruptedException {
        DataHolder<Integer> holder = new DataHolder<>();
        CompletableFuture<String> supplyAsyncFut = supplyAsync(() -> holder.processSomeData());
        supplyAsyncFut.join();
        assertEquals("process", supplyAsyncFut.get());
    }

    //supply Async And accept
    @Test
    public void testSupplyAsyncAccept() throws ExecutionException, InterruptedException {
        DataHolder<Integer> holder = new DataHolder<>();

        CompletableFuture<Void> acceptFut = supplyAsync(() -> holder.processSomeData())
                .thenAccept(System.out::println);
        acceptFut.join();
    }

    //supply Async, Apply And accept
    @Test
    public void testSupplyApplyAsyncAccept() throws ExecutionException, InterruptedException {
        DataHolder<Integer> holder = new DataHolder<>();

        CompletableFuture<Void> acceptFut = supplyAsync(() -> holder.processSomeData())
                .thenApplyAsync(String::toUpperCase)
                .thenAccept(System.out::println);
        acceptFut.join();
    }

    //supply Async, Apply And Run
    @Test
    public void testSupplyApplyAsyncRun() throws ExecutionException, InterruptedException {
        List<String> l = new ArrayList<>();
        DataHolder<Integer> holder = new DataHolder<>();
        CompletableFuture<Void> acceptFut = supplyAsync(() -> holder.processSomeData())
                .thenApplyAsync(String::toUpperCase)
                .thenApplyAsync(l::add)
                .thenRun(() -> System.out.println("all done, check result"));
        acceptFut.join();
        assertTrue(!l.isEmpty());
        assertEquals("PROCESS", l.get(0));
    }

    //test for compose

    public CompletableFuture<Integer> findQty() {
        sleep(1);
        return CompletableFuture.completedFuture(10);
    }

    public CompletableFuture<Double> findTotal(int qty) {
        sleep(2);
        return CompletableFuture.completedFuture(qty * 97.25);
    }

    public CompletableFuture<Double> notifyAndReturn(double total) {
        sleep(1);
        System.out.println("notifying , total is :" + total);
        return CompletableFuture.completedFuture(total);
    }

    @Test
    public void testCompose() {
        double total = findQty()
                .thenComposeAsync(this::findTotal)
                .thenComposeAsync(this::notifyAndReturn)
                .join();
        assertEquals(972.5, total, .00001);
    }

    //combine
    public CompletableFuture<Double> findPrice() {
        sleep(3);
        return CompletableFuture.completedFuture(97.125);
    }

    @Test
    public void testCombine() {

        double total = findQty().thenCombine(findPrice(), (qty, pri) -> qty * pri)
                .join();

        assertEquals(971.25, total, .0001);
    }
    //all

    public String task(String task, int secs) {
        sleep(secs);
        System.out.println("returing task is :" + task);
        return task;
    }

    @Test
    public void testAll() {

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> task("task 1", 1));
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> task("task 2", 2));
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> task("task 3", 2));

        CompletableFuture.allOf(task1, task2, task3)
                .thenRun(() -> System.out.println("all tasks done, exiting"))
                .join();

    }

    //exceptionally
    public double calculate(double total) {
        throw new NumberFormatException("infinity");
    }

    @Test
    public void testExceptionally() {
        CompletableFuture<Double> res = findQty()
                .thenApplyAsync(q -> q * 10.25)
                .thenApplyAsync(this::calculate)
                .exceptionally(ex -> {
                    System.out.println("exception occured, returning default:" + ex.getMessage());
                    return 0.0;
                });
        Double result = res.join();

        assertEquals(0.0, result, .0);
    }


    public void sleep(int secs) {
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setVal(DataHolder<Integer> holder) {
        holder.setVal(10);
    }


    class DataHolder<V> {
        private V val;

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

        public String processSomeData() {
            return "process";
        }
    }
}
