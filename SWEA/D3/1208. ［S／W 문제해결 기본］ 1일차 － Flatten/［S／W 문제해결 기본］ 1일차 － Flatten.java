import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        
        for(int test =1;test<=10;test++) {
                int N = Integer.parseInt(br.readLine());
				int[] arr = new int[100];
            
            st = new StringTokenizer(br.readLine()," ");
            for(int i =0;i<100;i++) arr[i] = Integer.parseInt(st.nextToken());
        	            int height =Integer.MAX_VALUE;

            while(N -->0) {
                int max = Integer.MIN_VALUE;
                int maxIdx = 0;
                int min = Integer.MAX_VALUE;
                int minIdx = 0;
               for(int j =0;j<100;j++) {
            		if(max < arr[j]) {
                    	max = arr[j];
                        maxIdx = j;
                    }
                   if(arr[j] !=0 && min > arr[j]) {
                   		min = arr[j];
                       minIdx = j;
                   }
            }

                             
                if(arr[maxIdx] - arr[minIdx] == 0) {
                height = 0;
                    break;
                }  else if(arr[maxIdx] - arr[minIdx] == 1) {
                height = 1;
                    break;
                }
                
                arr[maxIdx] -=1;
                arr[minIdx] +=1;

            }
            
               int max = Integer.MIN_VALUE;
                int maxIdx = 0;
                int min = Integer.MAX_VALUE;
                int minIdx = 0;
              for(int j =0;j<100;j++) {
            		if(max < arr[j]) {
                    	max = arr[j];
                        maxIdx = j;
                    }
                   
                   if(min > arr[j]) {
                   		min = arr[j];
                       minIdx = j;
                   }
            }
                
               
            
            height = max - min;
         
           	
        bw.write("#"+test+" "+height+"\n");
        } 
        
        

        bw.flush();
        br.close();
        bw.close();
}
}