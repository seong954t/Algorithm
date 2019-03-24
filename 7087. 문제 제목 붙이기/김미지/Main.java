package com.company;

import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test=1;
        int test_num = Integer.parseInt(br.readLine());

        while(test<=test_num){
            int in_test_num = Integer.parseInt(br.readLine());
            int temp_arr[] = new int[26];

            for(int i=0; i<in_test_num; i++){
                String temp = br.readLine();
                temp_arr[temp.charAt(0)-'A']++;
            }

            int count =0;

            for(int i=0; i<temp_arr.length; i++){
                if(temp_arr[i]>0){
                    count++;
                }else{
                    break;
                }
            }
            System.out.println("#"+test+" "+count);
            test++;
        }
    }
}