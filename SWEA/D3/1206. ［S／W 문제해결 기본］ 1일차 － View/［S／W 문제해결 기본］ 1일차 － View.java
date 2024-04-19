import java.io.*;
import java.util.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = 10;
        
        int idx = 1;
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
             
            st = new StringTokenizer(br.readLine()," ");
            for(int i =0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
      
            int answer = 0;
          for(int j =2;j<=N-2;j++) {
          		
              int now = arr[j];
              int min = Integer.MAX_VALUE;
              for(int k = j-2;k<=j+2;k++){
              		if(k == j) continue;
                  	if(now-arr[k]  <=0) {
                        min = 0;
                        break;} 
                 
                  min = Math.min(min,now-arr[k]);
              }
          
              answer += min;
          
          }
          
          bw.write("#"+idx+" "+answer+"\n");
            idx++;
        }
            
            
        
        bw.flush();
        br.close();
        bw.close();
        
	}
}