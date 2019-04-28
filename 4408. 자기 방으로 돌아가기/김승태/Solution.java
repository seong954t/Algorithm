import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer;
        int T, N, start, end, road[], answer;
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase<=T; testcase++){
            road = new int[200];
            answer = 0;
            N = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                start = Integer.parseInt(stringTokenizer.nextToken());
                end = Integer.parseInt(stringTokenizer.nextToken());
                if(end < start){
                    end = start - end;
                    start = start - end;
                    end = start + end;
                }
                start = getRoadPosition(start);
                end = getRoadPosition(end);
                for(; start <= end; start++){
                    road[start]++;
                    answer = Math.max(answer, road[start]);
                }
            }
            bufferedWriter.append("#"+testcase+" "+answer+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getRoadPosition(int room){
        return room % 2 == 0 ? (room - 2) / 2 : (room - 1) / 2;
    }
}
