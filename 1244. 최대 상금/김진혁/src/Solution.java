import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String sQuiz = st.nextToken();

            int chance = Integer.parseInt(st.nextToken());

            int[] quiz = new int[sQuiz.length()];

            for (int i = 0; i < sQuiz.length(); i++) {
                quiz[i] = Integer.parseInt(sQuiz.charAt(i) + "");
            }

            int maxValue = arrayRangeMax(quiz, 0, quiz.length);
            int maxCount = arrayValueCount(quiz, maxValue);

            int count = 0;

            if (maxCount == 1) {
                for (int i = 0; i < quiz.length && chance > count; i++) {
                    int maxIndex = indexValue(quiz, arrayRangeMax(quiz, i, quiz.length));
                    if (i != maxIndex) {
                        arraySwap(quiz, i, maxIndex);
                        count++;
                    }
                }

                while (chance > count) {
                    arraySwap(quiz, quiz.length - 1, quiz.length - 2);
                    count++;
                }
            } else {
                int[] maxIndexArray = maxIndexAndValue(quiz, maxValue, maxCount);
                ArrayList<IndexValue> maxIV = new ArrayList<>();

                for (int aMaxIndexArray : maxIndexArray) {
                    maxIV.add(new IndexValue(aMaxIndexArray, quiz[aMaxIndexArray]));
                }

                Collections.sort(maxIV);


                ArrayList<IndexValue> minIV = new ArrayList<>();

                int tempCount = 0;

                for (int i = 0; i < quiz.length; i++) {
                    if (quiz[i] != maxValue) {
                        if (tempCount < maxIndexArray.length) {
                            minIV.add(new IndexValue(i, quiz[i]));
                            tempCount++;
                        }
                    }
                }

                ArrayList<IndexValue> maxSwapIndex = new ArrayList<>();

                for (int i = 0; i < minIV.size() && chance > count; i++) {
                    if (minIV.get(i).x < maxCount) {
                        arraySwap(quiz, minIV.get(i).x, maxIV.get(i).x);

                        maxSwapIndex.add(new IndexValue(maxIV.get(i).x, quiz[maxIV.get(i).x]));

                        count++;
                        maxCount++;
                    }
                }

                ArrayList<IndexValue> original = new ArrayList<>();
                original.addAll(maxSwapIndex);

                Collections.sort(maxSwapIndex);

                for (int i = 0; i < original.size(); i++) {
                    quiz[original.get(i).x] = maxSwapIndex.get(i).y;
                }


            }

            bw.write("#" + t + " ");
            for (int i : quiz) {
                bw.write(i + "");
            }
            bw.write("\n");

        }

        bw.flush();
        bw.close();


    }

    private static int[] maxIndexAndValue(int[] quiz, int maxValue, int maxCount) {
        int[] set = new int[maxCount];
        int count = 0;
        for (int i = 0; i < quiz.length; i++) {
            if (quiz[i] == maxValue) {
                set[count] = i;
                count++;
            }
        }

        return set;
    }


    private static int[] arraySwap(int[] quiz, int x, int y) {

        int temp = quiz[x];
        quiz[x] = quiz[y];
        quiz[y] = temp;

        return quiz;
    }

    private static int indexValue(int[] quiz, int maxValue) {
        for (int i = quiz.length - 1; i > 0; i--) {
            if (maxValue == quiz[i]) {
                return i;
            }
        }
        return 0;
    }

    private static int arrayValueCount(int[] quiz, int i) {
        int count = 0;
        for (int aQuiz : quiz) {
            if (i == aQuiz) {
                count++;
            }
        }
        return count;
    }

    private static int arrayRangeMax(int[] quiz, int x, int length) {
        int max = 0;
        for (int i = x; i < length; i++) {
            if (quiz[i] > max) {
                max = quiz[i];
            }
        }

        return max;
    }

    private static class IndexValue implements Comparable<IndexValue> {
        int x;
        int y;

        public IndexValue(int index, int value) {
            this.x = index;
            this.y = value;
        }

        @Override
        public int compareTo(IndexValue o) {
            if (this.y > o.y) {
                return 1;
            } else if (this.y == o.y) {
                if (this.x < o.x) {
                    return 1;
                }
            }
            return -1;
        }
    }
}