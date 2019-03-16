import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
                 
        for(int i =1; i<=10; i++){
            int n = input.nextInt();
            int count=0, temp = 0;
            int arr[] = new int[n];

            for(int j=0; j<arr.length; j++){
                arr[j] = input.nextInt();
            }
             
            for(int j=2; j<arr.length-2; j++){
                temp = arr[j];
                if(arr[j] == 0)
                    continue;
                while (temp>=0){
                    //  조건 체크
                    if(temp > arr[j+1] && temp > arr[j-1] && temp > arr[j-2] && temp > arr[j+2]){
                        count++;
                        temp--;
                    }
                    else{
                        break;
                    }
                }
            }      
            System.out.println("#"+i +" " + count);            
        }
    }
}
