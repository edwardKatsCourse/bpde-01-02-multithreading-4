package com.company.intro;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        /**
         * wait/notify/notifyAll
         * concurrent collections/stream API
         */
        Object lock = new Object();

        synchronized (lock) {
            //thread 1
            lock.wait(3000);
            //end thread 1

            //thread 2
//            lock.notify();
            //end thread 2
        }



//        synchronized (lock) {
//            lock.wait();
//            new Object().notify();
//        }

        System.out.println("get me out of here!!");
    }
}