import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int numberofCase = 0; //몇개의 케이스가 있는지
        int numberofWord; //단어의 개수
        int numberofA = 65; // A 의 아스키코드 값
        char[] wordArray;
        int[] answerArray; // 정답 배열
        int point;
        char[] orderArray;

        Scanner sc = new Scanner(System.in);
        numberofCase = sc.nextInt(); // 첫번째 인풋을 numberofCase로 저장

        for (int i=0; i<numberofCase; i++) { // 케이스 개수만큼 반복
            numberofWord = sc.nextInt(); // 각 케이스마다 앞으로 올 단어의 개수
            wordArray = new char[numberofWord]; //단어 개수만큼 배열 생성
            orderArray = new char[26];
            for(int m=0; m<orderArray.length; m++) {
                orderArray[m] = ' ';
            }
            answerArray = new int[numberofCase];
            for(int j=0; j<wordArray.length; j++) { //단어 개수만큼 반복
                wordArray[j] = sc.next().charAt(0); //배열에 단어 앞글자 넣기
                orderArray[wordArray[j]-numberofA] = wordArray[j];
            }
            point=0; //point 값 초기화
            for(int m=0; m<orderArray.length; m++) {
                if(orderArray[m]!=' ') {
                    point++;
                }
                else break;
            }
            answerArray[i] = point;
            System.out.println("#" + (i+1) + " " + answerArray[i]);
        }
    }
}
