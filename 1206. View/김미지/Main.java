package com.company;

import java.io.*;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = 1;
        int test_len;

        String floor;
        String[] floor_arr = null;
        int max_floor;

        while(test<=10){
            int count = 0;
            test_len = Integer.parseInt(br.readLine());
            floor = br.readLine();
            floor_arr = floor.split(" ");
            for(int i = 2; i<test_len-2; i++) {
                max_floor = Math.max((Math.max(Integer.parseInt(floor_arr[i + 1]), Integer.parseInt(floor_arr[i + 2]))), (Math.max(Integer.parseInt(floor_arr[i - 1]), Integer.parseInt(floor_arr[i - 2]))));
                max_floor = Integer.parseInt(floor_arr[i])-max_floor;
                if (max_floor > 0) {
                    count+=max_floor;
                }
            }
            System.out.println("#"+test+" "+count);
            test++;
        }
    }
}
