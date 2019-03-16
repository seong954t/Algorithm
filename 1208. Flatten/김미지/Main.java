package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = 1;
        int dump_count;
        int MAX = -1;
        int MIN = -1;
        String[] dump_arr = null;
        int temp_index_for_max = 0;
        int temp_index_for_min = 0;
        String dump;
        while(test <= 10){
            dump_count = Integer.parseInt(br.readLine());
            dump = br.readLine();
            dump_arr = dump.split(" ");
            for(int i = 0; i<dump_count; i++){
                MAX = Integer.parseInt(dump_arr[0]);
                MIN = Integer.parseInt(dump_arr[0]);
                for(int j = 0; j<100; j++) {
                    int temp = Integer.parseInt(dump_arr[j]);
                    if (MAX < temp) {
                        MAX = temp;
                        temp_index_for_max = j;
                    }
                    if (temp <= MIN){
                        MIN = temp;
                        temp_index_for_min = j;
                    }
                }
                dump_arr[temp_index_for_max] = Integer.parseInt(dump_arr[temp_index_for_max])-1+"";
                dump_arr[temp_index_for_min] = Integer.parseInt(dump_arr[temp_index_for_min])+1+"";
            }
            System.out.println("#"+test+" "+(MAX-MIN));
            test++;
        }

    }
}
