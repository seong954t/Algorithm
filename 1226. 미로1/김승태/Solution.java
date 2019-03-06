import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T, X = 0, Y = 0;
        String mazeRow;
        char maze[][] = new char[16][16];
        for(int testcase = 1; testcase<=10; testcase++){
            T = sc.nextInt();
            for(int i = 0; i<16; i++){
                mazeRow = sc.next();
                maze[i] = mazeRow.toCharArray();
                for(int j = 0; j<16; j++){
                    if(maze[i][j] == '2'){
                        X = i;
                        Y = j;
                    }
                }
            }
            System.out.println(String.format("#%d %d", T, findEnd(maze, X, Y) ? 1 : 0));
        }
    }

    static boolean findEnd(char maze[][], int X, int Y){
        switch (maze[X][Y]){
            case '1':
                return false;
            case '3':
                return true;
            default:
                maze[X][Y] = '1';
                return findEnd(maze, X+1, Y) || findEnd(maze, X-1, Y) || findEnd(maze, X, Y+1) || findEnd(maze, X, Y-1);
        }
    }
}
