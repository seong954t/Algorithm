import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int N, box[] = new int[100];
        for(int testcase = 1; testcase<=10; testcase++){
            N = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i<100; i++){
                box[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            bufferedWriter.write("#"+testcase+" "+getGapValue(box, N)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int getGapValue(int box[], int N){
        boolean isFlat;
        int temp;
        Arrays.sort(box);
        for(int i = 0; i<N; i++){
            isFlat = false;
            box[99]--;
            temp = box[99];
            if(temp + 1 == box[98]) {
                for (int j = 97; j >= 0; j--) {
                    if (temp >= box[j]) {
                        box[99] = box[j+1];
                        box[j+1] = temp;
                        break;
                    }
                }
            }
            box[0]++;
            temp = box[0];
            if(temp - 1 == box[1]) {
                for (int j = 2; j < 100; j++) {
                    if (temp <= box[j]) {
                        box[0] = box[j-1];
                        box[j-1] = temp;
                        break;
                    }
                    if(j == 99){
                        isFlat = true;
                    }
                }
            }
            if(isFlat){
                break;
            }
        }
        return box[99] - box[0];
    }

}
