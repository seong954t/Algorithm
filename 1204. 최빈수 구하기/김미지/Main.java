package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line_num = Integer.parseInt(br.readLine());
        int test=1;
        while(test<=line_num){
            br.readLine();
            String[] temp_1 = br.readLine().split(" ");
            int[] temp = Arrays.stream(temp_1).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(temp);
            int first = temp[0];
            int[] count_arr = new int[101];
            int count = 0;
            int MAX = -1;
            for(int i=1; i<temp.length; i++){
                if(first == temp[i]){
                    count++;
                }else{
                    count_arr[first] = count;
                    count = 0;
                }
                first = temp[i];
            }

            int MAX_for_result = count_arr[0];
            int result = 0;
            for(int i=0; i<count_arr.length; i++){
                if(MAX_for_result<=count_arr[i]){
                    MAX_for_result=count_arr[i];
                    result = i;
                }
            }


            System.out.println("#"+test+" "+result);
            test++;
        }

    }
}
