package com.company.bread_factory;

public class DeliveryBuffer {

    private Integer breadToDeliver;

//    public synchronized void accountIn = synchronized(this)
//    public STATIC synchronized void accountIn = synchronized(DeliveryBuffer.class)

    //Хлеб пришел из фабрики
    public synchronized void accountIn(Integer breadFromFactory) throws InterruptedException {

        //Не могу принять новый хлеб. Некуда класть, пока не продам предыдущую партию
        while (this.breadToDeliver != null) {
            //thread 1
            //Жду, пока продастся предыдущая партия
            this.wait();
        }

        //thread 2

        //Если мы попали сюда - значит предыдущая партия продана и есть куда класть новую
        this.breadToDeliver = breadFromFactory;

        //Уведомляю всем, кто ждет хлеба, что можно прийти забирать
        this.notifyAll();
    }

    //Процес отдачи хлеба конечному заказчику
    public synchronized Integer deliverBreadToCustomer() throws InterruptedException {

        //Пока нечего отдавать - крчусь в цикле
        while (this.breadToDeliver == null) {
            //thread 3

            //Жду пока хлеб привезут с фабрики
            this.wait();
        }

        //Если мы попали сюда - значит хлеб пришел с фабрики и его можно отдавать клиенту
        Integer bread = this.breadToDeliver;

        //Опустошаю контейнер для перевозки хлеба
        this.breadToDeliver = null;

        //thread 4
        //Всем, кто ждал, пока освободится место, МЕСТО СВОБОДНО, НЕСИТЕ ЕСЧЕ ХЛЕБА
        this.notifyAll();

        //Отдать хлеб заказкичу
        return bread;
    }
}
