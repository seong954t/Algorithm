import java.io.*;
import java.util.*;

public class Solution {
    static int[][] tree;
    static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tree = new int[v+1][2];
            parents = new int[v+1];

            for (int i = 0; i < e; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if (tree[parent][0] == 0){
                    tree[parent][0] = child;
                } else {
                    tree[parent][1] = child;
                }

                parents[child] = parent;
            }

            int lca = findLCA(a, b);
            int size = lca == 1 ? v : countSubtreeSize(lca);

            bw.append("#" + t + " " + lca + " " + size + "\n");
            bw.flush();
        }
        bw.close();
    }

    static int findLCA(int a, int b) {
        ArrayList<Integer> aAncestor = new ArrayList<>();
        ArrayList<Integer> bAncestor = new ArrayList<>();

        int current = parents[a];
        while (current != 0) {
            aAncestor.add(current);
            current = parents[current];
        }

        current = parents[b];
        while (current != 0) {
            bAncestor.add(current);
            current = parents[current];
        }

        for (Integer i : aAncestor) {
            if (bAncestor.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    static int countSubtreeSize(int root){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(tree[root][0]);

        int result = 1;
        if (tree[root][1] != 0) queue.add(tree[root][1]);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result++;
            if (tree[current][0] != 0) queue.add(tree[current][0]);
            if (tree[current][1] != 0) queue.add(tree[current][1]);
        }
        return result;
    }
}