import java.util.Scanner;
public class Solution{
    public static void main(String args[]){       
        int N, M, testcase;
        Scanner input = new Scanner(System.in);
        testcase = input.nextInt();

        for(int x=1; x<=testcase; x++){           
            int winnerCount =0, winnerSolvedCount=0;
            N = input.nextInt();
            M = input.nextInt();
            for(int i=0; i<N; i++){
                int rowsolvedProblem =0;
                for(int j=0; j<M; j++){
                    rowsolvedProblem += input.nextInt();
                }
                
                //  참가자가 푼 문제가 승리자의 푼 문제보다 많을 때
                if(rowsolvedProblem >= winnerSolvedCount){                   
                    if((rowsolvedProblem == winnerSolvedCount)){
                        winnerCount++;
                    }
                    else{
                        winnerSolvedCount = rowsolvedProblem;
                        winnerCount =1;
                    }
            }
        }
        System.out.println("#"+x+" "+winnerCount+" "+winnerSolvedCount);
        sc.close();
        }       
    }
}
