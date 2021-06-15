package com.learning.restassured;

public class SampleThread1 extends Thread{

    public void run(){
        System.out.println("Thread" + Thread.currentThread().getId() + "is running");
    }


}
