package threads;

import org.apache.log4j.Logger;

class Common {
    Logger log = Logger.getLogger(Common.class);
    public synchronized void synchronizedMethod1() {
        log.info("synchronizedMethod1 called");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("synchronizedMethod1 done");
    }

    public synchronized void synchronizedMethod2() {
        log.info("synchronizedMethod2 called");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("synchronizedMethod2 done");
    }
}

public class MyThread extends Thread {
    private int id = 0;
    private Common common;
    Logger log = Logger.getLogger(MyThread.class);

    public MyThread(String name, int no, Common object) {
        super(name);
        common = object;
        id = no;
    }

    public void run() {
        log.info("Running Thread" + this.getName());
        try {
            if (id == 0) {
                common.synchronizedMethod1();
            } else {
                common.synchronizedMethod2();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Common c = new Common();
        MyThread t1 = new MyThread("MyThread-1", 0, c);
        MyThread t2 = new MyThread("MyThread-2", 1, c);
        t1.start();
        t2.start();
    }
}
