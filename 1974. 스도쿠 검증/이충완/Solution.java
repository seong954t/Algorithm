import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= N; tc++) {
            boolean isOk = true;
            boolean[] row = null;
            boolean[] nemo1 = null;
            boolean[] nemo2 = null;
            boolean[] nemo3 = null;
            boolean[][] col = new boolean[10][10];

            String[][] lines = new String[9][];
            for (int z = 0; z < 9; z++) {
                lines[z] = br.readLine().split(" ");
            }

            forout:
            for (int i = 0; i < 9; i++) {
                row = new boolean[10];
                if (i % 3 == 0) {
                    nemo1 = new boolean[10];
                    nemo2 = new boolean[10];
                    nemo3 = new boolean[10];
                }

                for (int j = 0; j < 9; j++) {
                    int value = Integer.parseInt(lines[i][j]);
                    // 각 행 검사.
                    if (!row[value]) {
                        row[value] = true;
                    } else {
                        isOk = false;
                        break forout;
                    }

                    // 모든 열 검사
                    if (!col[value][j]) {
                        col[value][j] = true;
                    } else {
                        isOk = false;
                        break forout;
                    }

                    // 네모 검사
                    int who = j / 3;
                    switch (who) {
                        case 0:
                            if (!nemo1[value]) {
                                nemo1[value] = true;
                            } else {
                                isOk = false;
                                break forout;
                            }
                            break;
                        case 1:
                            if (!nemo2[value]) {
                                nemo2[value] = true;
                            } else {
                                isOk = false;
                                break forout;
                            }
                            break;
                        case 2:
                            if (!nemo3[value]) {
                                nemo3[value] = true;
                            } else {
                                isOk = false;
                                break forout;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            if (isOk) {
                bw.write("#" + tc + " 1\n");
            } else {
                bw.write("#" + tc + " 0\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
