import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        char sudoku[][] = new char[9][9];
        T = Integer.parseInt(bufferedReader.readLine());
        for(int testcase = 1; testcase <= T; testcase++){
            for(int i = 0; i<9; i++){
                sudoku[i] = bufferedReader.readLine().replaceAll(" ", "").toCharArray();
            }
            bufferedWriter.write("#"+testcase+" "+isCorrectSudoku(sudoku)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int isCorrectSudoku(char sudoku[][]){
        for(int i = 0; i<9; i++){
            if(!isCorrectSudokuVertical(sudoku, i)){
                return 0;
            }
            if(!isCorrectSudokuHorizen(sudoku, i)){
                return 0;
            }
            if(!isCorrectSudokuRectangle(sudoku, i)){
                return 0;
            }
        }
        return 1;
    }

    static boolean isCorrectSudokuVertical(char sudoku[][], int sequence){
        Set numberSet = new LinkedHashSet();
        for(int i = 0; i<9; i++){
            numberSet.add(sudoku[i][sequence]);
        }
        return numberSet.size() == 9;
    }

    static boolean isCorrectSudokuHorizen(char sudoku[][], int sequence){
        Set numberSet = new LinkedHashSet();
        for(int i = 0; i<9; i++){
            numberSet.add(sudoku[sequence][i]);
        }
        return numberSet.size() == 9;
    }

    static boolean isCorrectSudokuRectangle(char sudoku[][], int sequence){
        Set numberSet = new LinkedHashSet();
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                numberSet.add(sudoku[((sequence/3)*3)+i][((sequence%3)*3)+j]);
            }
        }
        return numberSet.size() == 9;
    }
}
