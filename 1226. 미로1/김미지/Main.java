package com.company;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int test_num = sc.nextInt();
        int line = 1;
        int n,m,f;
        while(line <= test_num){
            n = sc.nextInt();
            int[] for_mapping = new int[1000000];

            int max = -1;
            for (int i = 0 ; i<n; i++){
                m = sc.nextInt();
                f = sc.nextInt();
                for_mapping[m] = f;
                if(max < m){
                    max = m;
                }
            }

            ArrayList<Integer> for_result;
            ArrayList<Integer> clone_result = null;

            for (int i = max; i>=0; i--){
                if(for_mapping[i] != 0){

                    int temp_int = i;
                    for_result = new ArrayList<Integer>();

                    while(for_mapping[temp_int]!=0){
                        for_result.add(temp_int);
                        for_result.add(for_mapping[temp_int]);
                        temp_int = for_mapping[temp_int];
                    }

                    if(clone_result == null || for_result.size() > clone_result.size()){
                        clone_result = (ArrayList<Integer>) for_result.clone();
                    }

                }
            }

            System.out.print("#" + line + " ");
            for(int i = 0; i<clone_result.size(); i++){
                System.out.print(clone_result.get(i) + " ");
            }
            System.out.println();
            line++;
        }
    }
}
