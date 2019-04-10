import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int numberofCase;
        String[] arrayInput;
        String output;

        Scanner sc = new Scanner(System.in);

        numberofCase = sc.nextInt();
        sc.nextLine();

        for(int cycletime = 0; cycletime < numberofCase; cycletime++) {
            String input = sc.nextLine();
            arrayInput = input.split(" ");

            if(arrayInput[0].contains(arrayInput[1])) { // A에 B가 포함 즉 몇번있는지 검사해야함
                output = arrayInput[0].replaceAll(arrayInput[1], "!");
            }
            else { // A에 B가 없음 즉 글자수 그대로
                output = arrayInput[0];
            }

            System.out.println("#" + (cycletime+1) + " " + output.length());
        }
    }
}
