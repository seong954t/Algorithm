package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int M = 0;
        int N = 0;

        int test_num = sc.nextInt();
        int line = 1;

        while(line <= test_num){
            int person_count = 0;
            int MAX = 0;
            N = sc.nextInt();
            M = sc.nextInt();

            for(int i = 0; i<N; i++){
                int correct_count = 0;
                for(int j = 0; j<M; j++){
                    correct_count += sc.nextInt();
                }
                if(MAX<correct_count){
                    person_count = 1;
                    MAX = correct_count;
                }else if(MAX==correct_count){
                    person_count++;
                    MAX = correct_count;
                }
            }
            System.out.println("#"+line+" "+person_count+" "+MAX);
            line++;
        }
    }

}