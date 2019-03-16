package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = 1;
        while (test<=10){
            int max_column = -1;
            int max_row =-1;
            int column,row,diagonal_1 = 0,diagonal_2 = 0;
            br.readLine();
            int[][] arr = new int[100][100];
            for(int i =0; i<100; i++){
                String[] temp = br.readLine().split(" ");
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(temp[j]);

                }
            }

            for(int i=0; i<100;i++){
                column=0;
                row =0;
                for(int j=0; j<100; j++){
                    row += arr[j][i];
                    column += arr[i][j];
                }
                diagonal_1 += arr[i][i]; //오른쪽방향
                diagonal_2 += arr[arr.length-1][i];

                max_row = Math.max(row,max_row);
                max_column =Math.max(column,max_column);
            }
             System.out.println("#"+test+" "+Math.max(Math.max(max_row,max_column),Math.max(diagonal_1,diagonal_2)));
            test++;

            }

        }
    }
