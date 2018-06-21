package com.company.bread_factory;

public class BreadFactory extends Thread {

    private long sleepPeriod;
    private DeliveryBuffer deliveryGuy;
    private Integer breadStartId;

    public BreadFactory(String name,
                        long sleepPeriod,
                        DeliveryBuffer deliveryGuy,
                        Integer breadStartId) {

        super(name);
        this.sleepPeriod = sleepPeriod;
        this.deliveryGuy = deliveryGuy;
        this.breadStartId = breadStartId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer currentBreadId = breadStartId++;

                System.out.printf("Bread #%s was baked by [%s] factory\n", currentBreadId, this.getName());

                deliveryGuy.accountIn(currentBreadId);
                Thread.sleep(sleepPeriod);
            } catch (InterruptedException e) {
                System.out.println("Baking system failure");
                break;
            }

        }

    }
}
