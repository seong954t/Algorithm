import java.io.*;
import java.util.*;

public class Solution {

    static int UP = 1;
    static int DOWN = 2;
    static int LEFT = 3;
    static int RIGHT = 4;
    static int DIRECTION[][] = {
            {0, 0},
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        
        int T, N, M, K, X, Y, MN, D;
        Microbe microbeArray[] = new Microbe[1001];
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());
            for (int i = 0; i < K; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                X = Integer.parseInt(stringTokenizer.nextToken());
                Y = Integer.parseInt(stringTokenizer.nextToken());
                MN = Integer.parseInt(stringTokenizer.nextToken());
                D = Integer.parseInt(stringTokenizer.nextToken());
                microbeArray[i] = new Microbe(X, Y, D, MN);
            }

            bufferedWriter.append("#"+testcase+" "+getMicrobeNum(microbeArray, N, M, K)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getMicrobeNum(Microbe microbeArray[], int N, int M, int K){
        int answer = 0;
        Microbe tempMicrobe;
        ConflictMicrobe conflictMicrobe[][], tempConflictMicrobe;
        for(int i = 0; i<M; i++){
            conflictMicrobe = new ConflictMicrobe[101][101];
            for(int j = 0; j<K; j++){
                tempMicrobe = microbeArray[j];
                if(Objects.nonNull(tempMicrobe)) {
                    tempMicrobe.movePosition();
                    tempConflictMicrobe = conflictMicrobe[tempMicrobe.X][tempMicrobe.Y];

                    if ((tempMicrobe.X == 0 || tempMicrobe.X == N - 1) ||
                            (tempMicrobe.Y == 0 || tempMicrobe.Y == N - 1)) {
                        tempMicrobe.reverseDirection();
                    }

                    if (Objects.isNull(tempConflictMicrobe)) {
                        conflictMicrobe[tempMicrobe.X][tempMicrobe.Y] = new ConflictMicrobe(j, tempMicrobe.MN);
                    } else {
                        if (tempConflictMicrobe.maxMN < tempMicrobe.MN) {
                            tempConflictMicrobe.maxMN = tempMicrobe.MN;
                            tempMicrobe.MN += microbeArray[tempConflictMicrobe.microbePosition].MN;
                            microbeArray[tempConflictMicrobe.microbePosition] = null;
                            tempConflictMicrobe.microbePosition = j;
                        } else {
                            microbeArray[tempConflictMicrobe.microbePosition].MN += microbeArray[j].MN;
                            microbeArray[j] = null;
                        }
                    }
                }
            }
        }
        for(int i = 0; i<K; i++){
            if(Objects.nonNull(microbeArray[i])) {
                answer += microbeArray[i].MN;
            }
        }
        return answer;
    }

    static class ConflictMicrobe{
        int microbePosition, maxMN;

        ConflictMicrobe(int microbePosition, int maxMN){
            this.microbePosition = microbePosition;
            this.maxMN = maxMN;
        }
    }

    static class Microbe{
        int X, Y, D, MN;

        Microbe(int X, int Y, int D, int MN){
            this.X = X;
            this.Y = Y;
            this.D = D;
            this.MN = MN;
        }

        void movePosition(){
            X += DIRECTION[D][0];
            Y += DIRECTION[D][1];
        }

        void reverseDirection(){
            if(D == UP){
                D = DOWN;
            } else if(D == DOWN){
                D = UP;
            } else if(D == LEFT){
                D = RIGHT;
            } else if(D == RIGHT){
                D = LEFT;
            }
            MN /= 2;
        }
    }
}
