package com.금속막대;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            Map<Integer, Integer> male = new HashMap<>();
            Map<Integer, Integer> female = new HashMap<>();

            for (Integer i = 0; i < N; i++) {
                male.put(i, sc.nextInt());
                female.put(i, sc.nextInt());
            }

            StringBuilder concator = new StringBuilder();
            String compare = "";
            for (Integer key : male.keySet()) {
                concator.append(male.get(key)).append(" ").append(female.get(key));

                Integer nextKey = key;
                while (male.containsValue(female.get(nextKey))) {
                    for (Integer findKey : male.keySet()) {
                        if (male.get(findKey).equals(female.get(nextKey))) {
                            concator.append(" ").append(male.get(findKey)).append(" ").append(female.get(findKey));
                            nextKey = findKey;
                            break;
                        }
                    }
                }
                if (compare.length() < concator.toString().length())
                    compare = concator.toString();
                concator = new StringBuilder();
            }
            result.append("#").append(tc).append(" ").append(compare).append("\n");
        }
        System.out.println(result.toString());
        sc.close();
    }
}
