import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int testCaseNum;
        int dayNum;
        String[] priceStringArray;
        int[] priceIntArray;
        String price;
        long profit;
        int numberofItem;
        long[] profitArray;

        Scanner sc = new Scanner(System.in);
        testCaseNum = sc.nextInt();
        sc.nextLine();
        profitArray = new long[testCaseNum];

        for(int cycletime=0; cycletime<testCaseNum; cycletime++) {
            profit=0;
            numberofItem=0;
            dayNum = sc.nextInt();
            sc.nextLine();
            price = sc.nextLine();

            priceStringArray = price.split(" ");
            priceIntArray = new int[priceStringArray.length];
            for(int i=0; i<priceStringArray.length; i++) { //int 배열 만들기
                priceIntArray[i] = Integer.parseInt(priceStringArray[i]);
//                System.out.println(priceIntArray[i]);
            }

            //max 값을 찾아서 max일때 판다.
            //max이후에 max값을 다시 갱신한다.
            //갱신할수있으면 구매 다시 한다.
            int maxIndex=toFindMaxIndex(priceIntArray, 0); //최대값구하기

            // 사고파는 알고리즘
            for(int k=0; k<priceIntArray.length; k++) {
                if(maxIndex==0) { //만약 처음거가 최대면 안사는게 이득
                    profit=0;
                    profitArray[k] = 0;
                    break;
                }
                else if(k==maxIndex) { //최대값이면 팔아야한다
                    profit += numberofItem * priceIntArray[k]; //다팔고
                    numberofItem=0; //산 개수는 0이되고
                    if(maxIndex+1<priceIntArray.length) {
                        maxIndex = toFindMaxIndex(priceIntArray,k+1);
                    }
                    //디음 최대값을 찾는다
                }
                else { //최대값이 아닐때는 하나씩 사야한다
                    profit -= priceIntArray[k];
                    numberofItem++;
                }
            }
            profitArray[cycletime] = profit; //이득 저장
        }

        for(int m=0; m<profitArray.length; m++) {
            System.out.println("#" + (m+1) + " " + profitArray[m]);
        }
        System.out.println("finish");
    }
        public static int toFindMaxIndex(int[] priceIntArray, int index) {
            int max = priceIntArray[index];
            int maxIndex=index;
            for(int j=index; j<priceIntArray.length; j++) { //최대값 찾기
                if(priceIntArray[j] > max) {
                    max = priceIntArray[j];
                    maxIndex = j;
                }
            }
            return maxIndex;
        }

}
