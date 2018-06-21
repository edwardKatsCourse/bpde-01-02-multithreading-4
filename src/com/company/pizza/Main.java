package com.company.pizza;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PizzaProcessing pizzaProcessing = new PizzaProcessing();

        Thread customer = new Thread(new Runnable() {
            @Override
            public void run() {
                pizzaProcessing.eatPizza();
            }
        });
        customer.start();
        Thread.sleep(5000);
        Thread deliverer = new Thread(new Runnable() {
            @Override
            public void run() {
                pizzaProcessing.deliver();
            }
        });
        deliverer.start();
    }
}
