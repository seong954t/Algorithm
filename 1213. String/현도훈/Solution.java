import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int numberofCase;

        Scanner sc = new Scanner(System.in);


        for(int cycletime = 0; cycletime < 10; cycletime++) {
            numberofCase = sc.nextInt();
            sc.nextLine();
            String word = sc.nextLine();
            String sentence = sc.nextLine();
            int count = 0;

            while(sentence.contains(word)) {
                sentence = sentence.substring(sentence.indexOf(word)+word.length());
                count++;
            }

            System.out.println("#" + (cycletime+1) + " " + count);


        }
    }
}
