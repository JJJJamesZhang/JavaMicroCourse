package com.samsclub;

public class Main {
    public static Object baozi = null;
    public static void main(String[] args) throws InterruptedException {

        // write your code here
        Thread consumerThread = new Thread(()->{
            if (baozi == null){
                System.out.println("waiting");
                Thread.currentThread().suspend();
                System.out.println("buying baozi");
            }
        });
        consumerThread.start();

        Thread.sleep(3000);
        baozi = new Object();
        consumerThread.resume();
        System.out.println("notify consumer");
    }
}
