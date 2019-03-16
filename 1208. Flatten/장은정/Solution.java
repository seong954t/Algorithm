import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution{
    static int arr[] = new int [100];
     
    public static int getMax(){
        int maxIndex =0, max = 0;
        for(int i=0; i<100; i++){
            if(arr[i]>max){
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }
      
    public static int getMin(){
        int minIndex = 0, min =100;
        for(int i=0; i<100; i++){
            if(arr[i]<min){
                minIndex = i;
                min = arr[i];
            }
        }
        return minIndex;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));        
        for(int tc =1; tc<=10;t++){ 
             
            int dumpTimes = Integer.parseInt(in.readLine());   
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0; i<100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
              
            for(int i=0; i<dumpTimes; i++){
                arr[getMax()]--;
                arr[getMin()]++;
            }
              
            int result = arr[getMax()] - arr[getMin()];
            System.out.println("#"+tc+" "+result);
        }
    }
      
 
}
