package com.company.bread_factory;

public class Main {
    public static void main(String[] args) {
        /**
         * Producer/Consumer
         *
         * Producer - что-то производит/генерирует/передает
         * Consumer - читает/сохраняет/обрабатывает
         *
         * ОЧЕЕНЬ медленный Producer (1 thread)
         * Много/быстрый Consumer(10 threads)
         *
         * msg4
         * msg3
         * producer.setMessage(msg2)
         *
         * consumer.getMessage() -> msg1
         */

        DeliveryBuffer deliveryBuffer = new DeliveryBuffer();

        //new Thread(new BreadFactory()).start()
        //new BreadFactory().start()

        //BERLIN FACTORY
        new BreadFactory("Berlin" , 2000, deliveryBuffer, 10_000).start();
        //PARIS FACTORY
        new BreadFactory("Paris" , 2000, deliveryBuffer, 20_000).start();
        //LONDON FACTORY
        new BreadFactory("London", 2000, deliveryBuffer, 30_000).start();
        //TEL-AVIV FACTORY
        new BreadFactory("Tel-Aviv", 2000, deliveryBuffer, 40_000).start();
        //ROME
        new BreadFactory("Rome",2000, deliveryBuffer, 50_000).start();


        new Customer("LIDL", 1, deliveryBuffer).start();
        new Customer("METRO", 2, deliveryBuffer).start();
        new Customer("Kaufland",3, deliveryBuffer).start();
        new Customer("ALDI",4, deliveryBuffer).start();
    }
}
