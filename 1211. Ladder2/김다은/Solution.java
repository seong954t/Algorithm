import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = 100;
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            int[][] map = new int[size][size];

            for (int i = 0; i < size; i++){
                map[i] = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            }

            int min = Integer.MAX_VALUE;
            int result = 0;

            for (int i = 0; i < size; i++){
                if (map[0][i] == 0) continue;
                int currentX = i;
                int currentY = 1;
                int direct = 0; // 0: down, 1: left, 2: right
                int count = 1;

                while (currentY < 99) {
                    if (currentX > 0 && direct != 2 && map[currentY][currentX-1] == 1) { // left
                        direct = 1;
                        currentX--;
                    } else if (currentX < 99 && direct != 1 && map[currentY][currentX+1] == 1) { // right
                        direct = 2;
                        currentX++;
                    } else { // down
                        direct = 0;
                        currentY++;
                    }
                    count++;
                }

                if (min > count) {
                    min = count;
                    result = i;
                }

            }
            bw.append("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}
