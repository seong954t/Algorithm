import java.util.Scanner;

public class Solution{
    static int arr[];
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int count = input.nextInt();
            arr = new int[count];

            for (int i = 0; i < count; i++) {
                arr[i] = input.nextInt();
            }
            long sum =0;
            long max = arr[count-1];
            for (int i = count-2; i >=0; i--) {
                if(arr[i]>max){     //  max 값이 더 크면 max 값을 교체
                    max = arr[i];
                }
                sum += (max-arr[i]); 
            }

            System.out.println("#"+tc+" "+sum);
        }

        input.close();

    }
}
