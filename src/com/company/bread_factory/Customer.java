package com.company.bread_factory;

public class Customer extends Thread {

    private final int id;
    private final DeliveryBuffer deliveryGuy;

    public Customer(String name, int id, DeliveryBuffer deliveryGuy) {
        super(name);
        this.id = id;
        this.deliveryGuy = deliveryGuy;
    }

    //Integer lock = 0;
    //....

    //synchronized(lock) {
    // }
    //....
    //lock = -155

    @Override
    public void run() {
        while (true) {
            try {
                Integer breadId = deliveryGuy.deliverBreadToCustomer();
                System.out.printf("Bread ID: %s was sold to [#%s. %s] #%s\n", breadId, this.id, this.getName(), this.id);
            } catch (InterruptedException e) {
                System.out.println("Customer failure. Business is closed");
                break;
            }
        }
    }
}
