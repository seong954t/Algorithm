package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.*;
public class Main {
    private static int arr[][];
    private static boolean visited[][];
    private static int EXIT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // write your code here
        boolean result;
        int test = 1;
        int start = 0;
        int end = 0;

        while (test <= 10) {
            br.readLine();
            arr = new int[16][16];
            visited = new boolean[16][16];
            for (int i = 0; i < 16; i++) {
                String[] temp = br.readLine().split("");
                for (int j = 0; j < 16; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                    if(arr[i][j] == 2){
                        start = i;
                        end = j;
                    }
                }
            }
            result = finding(start,end);
            int temp = result ? 1 : 0;
            System.out.println("#"+test+" "+temp);
            test++;
        }
        br.close();
    }

    public static boolean finding(int start, int end) {
        if(arr[start][end] == EXIT){
            return true;
        }
        if(arr[start][end] == 1||visited[start][end] || start<0||end<0||start>=arr.length||end>=arr.length) {//출구를 못찾음(start,end가 음수값이 나오면 안됨,
            return false;
        }else {
            visited[start][end] = true;
            if (finding(start + 1, end) || finding(start - 1, end) || finding(start, end - 1) || finding(start, end + 1)) {//출구 찾아야행
                return true;
            }
            return false;
        }
    }
}