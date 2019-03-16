import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        int caseNum;
      
        for(int x=1; x<=10; x++){
            int max = Integer.MIN_VALUE;
            int arr[][] = new int[101][101];
            caseNum = Integer.parseInt(br.readLine());
                //  코드 약간 막장;;  
                for(int i=0; i<100; i++){
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");                   
                    for(int j=0; j<100; j++){
                        arr[i][j] = Integer.parseInt(st.nextToken());
                        arr[i][100] += arr[i][j];
                    }
                    if(arr[i][100] > max)
                        max = arr[i][100];
                }
                 
                for(int i=0; i<100; i++){    
                    for(int j=0; j<100; j++){
                        arr[100][i] += arr[j][i];
                    }
                    if(arr[100][i] > max)
                        max = arr[100][i];
                }
                 
                for(int j=0; j<100; j++)
                    arr[100][100] += arr[j][j];
                if(max<arr[100][100])    
                    max = arr[100][100];
                  
                int temp = 0;
                 
                for(int j=0; j<100; j++)
                    temp += arr[j][99-j];
                if(max<temp)    
                    max = temp;
                 
                 
                System.out.println("#" + x + " " + max);
                 
        }
    }
 
}
