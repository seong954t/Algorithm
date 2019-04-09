import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int caseNumber;
        int distance;
        int count;

        Scanner sc = new Scanner(System.in);

        caseNumber = sc.nextInt();

        for(int cycletime=0; cycletime<caseNumber; cycletime++) {
            distance = sc.nextInt();
            if(distance >= 1000000) {
                System.out.println("#" + (cycletime+1) + " "  + 5);
                continue;
            }
            count = 0;
            while((distance / 10) >= 1 )  {
                count++;
                distance = distance / 10;
            }
            if(count == 0) {
                System.out.println("#" + (cycletime+1) + " "  + count);
            } else {
                System.out.println("#" + (cycletime+1) + " "  + (count-1));
            }
        }
    }
}
