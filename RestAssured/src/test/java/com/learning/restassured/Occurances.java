package com.learning.restassured;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.Map;

public class Occurances {

    public static void myOccurances() {
        char[] arr = {'a', 'b', 'c', 'd', 'a', 'c', 'a'};
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }

        }
        System.out.println(map);

    }

    public static void main(String[] args) {
        myOccurances();
    }
}
