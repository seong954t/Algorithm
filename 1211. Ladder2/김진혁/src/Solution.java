import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] ladder = new int[100][100];


        for(int t = 1; t <= 10; t++){
            br.readLine();
            for(int i =0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = 100000;
            int x = 0;
            for(int i = 0; i < 100; i++){
                if(ladder[0][i] == 1) {
                    boolean[][] isVisited = new boolean[100][100];
                    int xLength = minLength(ladder, isVisited, i);
                    if(min >= xLength){
                        min = xLength;
                        x = i;
                    }
                }
            }

            bw.write("#"+t + " " + x + "\n");

        }

        bw.flush();
        bw.close();
    }

    private static int minLength(int[][] ladder, boolean[][] isVisited, int x) {
        int count = 0;
        Point point = new Point(0, x);

        while(point.x <100){
            isVisited[point.x][point.y] = true;

            if (point.y+1 < 100 &&ladder[point.x][point.y + 1] == 1 && !isVisited[point.x][point.y + 1]) {
                point = new Point(point.x, point.y + 1);
            }
                else if (point.y-1 >= 0&& ladder[point.x][point.y - 1] == 1 && !isVisited[point.x][point.y - 1]) {
                    point = new Point(point.x, point.y - 1);
                }
                else{
                    point = new Point(point.x+1, point.y);
                }


            count++;
        }
        return count;
    }
}
