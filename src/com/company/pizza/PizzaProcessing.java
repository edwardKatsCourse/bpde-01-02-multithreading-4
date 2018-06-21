package com.company.pizza;

public class PizzaProcessing /*extends Object*/{
    private boolean isPizzaDelivered = false;
    //lock
    public void eatPizza() {

//        synchronized (lock) {
//        }
//              thread 2

        String message = null;
        synchronized (this) {
            while (!isPizzaDelivered) {
                try {
                    System.out.println("Waiting for pizza");
                    this.wait(); //sleep(10_000)
                    message = "hello";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Has not waited");
                }
            }
        }
        //customer
        System.out.println("yummy...");
        //Object lock = new Object();
                //

        //lock - разблокирован
        //     - wait/notify

//        synchronized (lock) {
        //thread 1
        //данные (которых нет)
        // lock.wait()
        //данные (которые уже есть)

        //}


        //synchronized (lock) {
        //пришли данные
        //lock.notifyAll()
        //}
        //thread 2



        //        synchronized (lock) {

        //}

        //        synchronized (lock) {

        //}

    }

    public void deliver() {
        synchronized (this) {
            System.out.println("Pizza arrived");
            this.isPizzaDelivered = true;
            this.notifyAll();
        }
        //deliverer
    }
}
