package com.learning.restassured;


public class TestReverse {

    public static void methodForAdd() {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        for (int i = 0; i < arr1.length - 1; i++) {
            int sum = 0;
            int j = i + 3;
            sum = arr1[i] + arr1[j];
            System.out.println("Sum Of 2 Numbers Selected = " + sum);


        }


    }

    public void myMet() {
        methodForAdd();

    }
        public static void main (String args[]){

            methodForAdd();

            String a = "I am Suresh G";
            char[] arr = a.toCharArray();

            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i]);
            }
        }

    }

