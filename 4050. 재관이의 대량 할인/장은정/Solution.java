import java.util.Scanner;
import java.util.Arrays;
 
public class Solution{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int arr[];
        for (int tc = 1; tc <= T; tc++) {
            int N = input.nextInt();
            arr = new int[N];
            int sum =0;
            for (int i = 0; i < N; i++) {
                arr[i] = input.nextInt();
                sum += arr[i];
            }
            Arrays.sort(arr);
 
            int div = N%3;
            int result =0;
            for (int i =div; i < N; i += 3) {
                sum  -=  arr[i];
            }
            System.out.println("#"+tc+" "+sum);
        }
        input.close();
    }
}
