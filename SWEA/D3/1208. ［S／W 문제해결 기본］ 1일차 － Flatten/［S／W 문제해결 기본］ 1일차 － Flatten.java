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

                Arrays.sort(arr);
                
             
                if(arr[arr.length-1] - arr[0] == 0) {
                height = 0;
                    break;
                }  else if(arr[arr.length-1] - arr[0] == 1) {
                height = 1;
                    break;
                }
                
                arr[arr.length-1] -=1;
                arr[0] +=1;

            }
            

               
            Arrays.sort(arr);
            height = arr[arr.length-1] - arr[0];
         
           	
        bw.write("#"+test+" "+height+"\n");
        } 
        
        

        bw.flush();
        br.close();
        bw.close();
}
}