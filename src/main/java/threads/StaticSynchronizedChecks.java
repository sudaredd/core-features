package threads;

import org.apache.log4j.Logger;

import static java.lang.Thread.sleep;
public class StaticSynchronizedChecks {

    static private final org.apache.log4j.Logger log = Logger.getLogger(StaticSynchronizedChecks.class);

    public static void main(String[] args) {
        StaticSynchronizedChecks staticSynchronizedChecks1 = new StaticSynchronizedChecks();
        StaticSynchronizedChecks staticSynchronizedChecks2 = new StaticSynchronizedChecks();
        StaticSynchronizedChecks staticSynchronizedChecks3 = new StaticSynchronizedChecks();
        new Thread(()->StaticSynchronizedChecks.test1("static test")).start();
        new Thread(()->staticSynchronizedChecks1.test1("obj test1")).start();
        new Thread(()->staticSynchronizedChecks2.test1("obj test2")).start();
        new Thread(()->staticSynchronizedChecks3.test1("obj test3")).start();

        new Thread(()->staticSynchronizedChecks1.test2("obj test1")).start();
        new Thread(()->staticSynchronizedChecks2.test2("obj test2")).start();
        new Thread(()->staticSynchronizedChecks3.test2("obj test3")).start();
    }

    public static synchronized void test1(String msg) {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(String.format("in test 1 message %s by thread %s", msg, Thread.currentThread().getName()));
    }
    public synchronized void test2(String msg) {
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(String.format("in test2 message %s by thread %s", msg, Thread.currentThread().getName()));
    }

}
