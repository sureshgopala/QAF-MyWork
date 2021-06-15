package com.learning.restassured;

public class MainThreadClass {

    public static void main(String[] args){
        int n =10;
        for(int i=0; i<n; i++){
            SampleThread1 thrd = new SampleThread1();
            thrd.start();
        }
    }
}
