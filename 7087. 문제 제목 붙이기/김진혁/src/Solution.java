import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            List<Character> subject = new ArrayList<>();

            for(int n = 0; n < N; n++){
                char[] line = br.readLine().toCharArray();
                subject.add(line[0]);
            }

            subject = subject.parallelStream().distinct().collect(Collectors.toList());

            Collections.sort(subject);

            int ASCII = 65;
            int count = 0;
            for (Character aSubject : subject) {
                if(aSubject == ASCII){
                    count++;
                    ASCII++;
                }else{
                    break;
                }
            }

            bw.write("#"+tc + " " + count + "\n");
        }

        bw.flush();
        bw.close();

    }
}
