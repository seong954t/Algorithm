package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
	    // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test =1;

        while(test<=10){
            br.readLine();
            int arr[][] = new int[100][100];
            int for_result[] = new int[100];

            for(int i=0; i<100;i++){
                String[] temp = br.readLine().split(" ");
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }
            int min = Integer.MAX_VALUE;
            int value = 0;
            for(int x=0; x<100; x++) {
                int count = 1;
                int for_X = 0;
                int for_Y = x;
                int before_direction = 0; //down 0 right 1 left 2


                if (arr[0][x] == 1) {
                    while (for_X != 100) {
                        if (for_Y < 99 && arr[for_X][for_Y + 1] == 1 && before_direction != 2) {
                            count++;
                            for_Y++;
                            before_direction = 1;
                        } else if (for_Y >= 1 && arr[for_X][for_Y - 1] == 1 && before_direction != 1) {
                            for_Y--;
                            count++;
                            before_direction = 2;
                        } else {
                            count++;
                            for_X++;
                            before_direction = 0;
                        }
                    }
                    if (min > count) {
                        min = count;
                        value = x;
                    }
                }
            }

            System.out.println("#"+test+" "+value);
            test++;
        }
    }
}