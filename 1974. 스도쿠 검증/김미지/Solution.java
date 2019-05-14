package 스도쿠검증;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int ic = 0; ic < tc; ic++) {
 
            int box[][] = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    box[i][j] = sc.nextInt();
                }
            }
            int [] answer = new int [10];
            for (int i = 0; i < 10; i++) {
                answer[i] = 1;
            }
            for (int i = 0; i < 9; i++) {
                 
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum = sum + box[i][j];
                }
                if (sum != 45) {
                    answer[ic] = 0;
                    break;
                }
            }
            for (int j = 0; j < 9; j++) {
                 
                int sum = 0;
                for (int i = 0; i < 9; i++) {
                    sum = sum + box[i][j];
                }
                if (sum != 45) {
                    answer[ic] = 0;
                    break;
                }
            }
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    int sum = 0;
                    for(int k=(3*i);k<3+(3*i);k++) {
                        for(int l=(3*j);l<3+(3*j);l++) {
                            sum += box[k][l];
                        }
                    }
                    if(sum!=45) {
                        answer[ic]=0;
                    }
                }
            }
             
             
            System.out.println("#"+(ic+1)+" "+answer[ic]);      
        }
    }
}
