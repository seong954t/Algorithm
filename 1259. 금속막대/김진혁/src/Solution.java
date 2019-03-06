import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        MetalLod metallod = new MetalLod(1,2);

        for(int t = 1; t <= T; t++){
            int metalNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<MetalLod> lodlist = new LinkedList<>();

            for(int m = 0; m < metalNum; m++){
                lodlist.add(new MetalLod(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // 처음 위치에 올 나사 찾기
            for(int i =0; i < metalNum; i++){
                int x =  lodlist.get(i).x;
                int j = 0;
                for(j = 0; j < metalNum; j++){
                    if(x == lodlist.get(j).y){
                        break;
                    }
                }
                if(j == metalNum){
                    lodlist.addFirst(lodlist.remove(i));
                }
            }


            for(int i = 0; i < metalNum-1; i++){
                int y = lodlist.get(i).y;
                int j = 0;
                for(j = i+1; j < metalNum; j++){
                    if(y == lodlist.get(j).x){
                        break;
                    }
                }
                lodlist.add(i+1, lodlist.remove(j));
            }

            System.out.print("#"+ t + " ");
            for(int i =0; i < metalNum; i++){
                System.out.print(lodlist.get(i).x + " " + lodlist.get(i).y + " ");
            }

            System.out.println();

        }

    }

    private static class MetalLod {
        int x;
        int y;
        public MetalLod(int i, int j) {
            x = i;
            y = j;
        }
    }
}
