import java.io.*;

public class Solution {
    static char[][] maze;
    //static boolean[][] visit_maze;
    static final int maze_size = 16;
    static int gone = 0;

    static final char road = '0';
    //static final char wall = '1';
    static final char start = '2';
    static final char finish = '3';
    static final char visited = '4';


    static int x_point = 0; // 1
    static int y_point = 0; // 1


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            int test_number = Integer.parseInt(br.readLine());

            maze = new char[maze_size][maze_size];
            // Build
            for (int i = 0; i < maze_size; i++) {
                maze[i] = br.readLine().toCharArray();
            }
//            visit_maze = new boolean[maze_size][maze_size];
//            for (int i=0;i<maze_size;i++){
//                for (int j=0; j<maze_size; j++){
//                    visit_maze[i][j] = false;
//                }
//            }

            // Search the start point
            for (int i = 0; i < maze_size; i++) {
                for (int j = 0; j < maze_size; j++) {
                    if (maze[i][j] == start) {
                        x_point = j;
                        y_point = i;
                        break;
                    }

                }
            }
            //visit_maze[x_point][y_point] =true;


            System.out.print("#" + test_number + " ");
            gone=0;
            mazeRun(x_point,y_point);
            System.out.println(gone);
            //System.out.println(x_point + " " + y_point);


        }
    }

    static void mazeRun(int x_point, int y_point){
        char left = maze[y_point][x_point - 1];
        char right = maze[y_point][x_point + 1];
        char up = maze[y_point - 1][x_point];
        char down = maze[y_point + 1][x_point];

        // 4면 중 1면이 '3'있으면 return 1
        if(left == finish || right ==finish || up==finish || down == finish){
            gone = 1;
            return;
        }

        // 왔던길로 다시가는 경우 처리하기 위해
        maze[y_point][x_point] = visited;

        if(left == road){
            mazeRun(x_point-1,y_point);
        }
        if(right == road){
            mazeRun(x_point+1,y_point);
        }
        if(up == road){
            mazeRun(x_point,y_point-1);
        }
        if(down ==road){
            mazeRun(x_point,y_point+1);
        }


        return;
    }
}




