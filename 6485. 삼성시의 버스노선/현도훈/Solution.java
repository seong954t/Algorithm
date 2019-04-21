import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int caseNumber;

        Scanner sc = new Scanner(System.in);

        caseNumber = sc.nextInt();

        for(int cycleTime=0; cycleTime<caseNumber; cycleTime++) {
            int N = sc.nextInt(); //
            sc.nextLine();
            int[][] intArray = new int[N][2];
            for(int i=0; i<N; i++) {
                String input = sc.nextLine(); //
                String[] inputArray = input.split(" ");
                intArray[i][0] = Integer.valueOf(inputArray[0]);
                intArray[i][1] = Integer.valueOf(inputArray[1]);
            }

            int P = sc.nextInt();
            int[] C = new int[P]; //출력 해야할 정류장 번호
            for(int j=0; j<P; j++) {
                C[j] = sc.nextInt();
            }

            int max = C[0]; //출력할 정류장 개수 찾기
            for(int i=0; i<C.length; i++) {
                if(C[i] > max) max = C[i];
            }

            int[] outputArray = new int[5000];

            for(int i=0; i<N; i++) {
                for(int j=0; j<max; j++) {
                    if(intArray[i][0] <= j+1 && intArray[i][1] >= j+1) {
                        outputArray[j]++;
                    }
                }
            }

            System.out.print("#" + (cycleTime+1));
            for(int i=0; i<C.length; i++) {
                System.out.print(" "+outputArray[C[i]-1]);
            }
        }
    }
}
