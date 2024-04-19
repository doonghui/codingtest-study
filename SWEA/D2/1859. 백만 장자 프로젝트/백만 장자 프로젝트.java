import java.io.*;
import java.util.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        
         int idx =1;
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
                        st = new StringTokenizer(br.readLine()," ");

            for(int i =0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
      
            int max =arr[N-1] ;
            long answer =0;
            for(int x = N-2;x >=0;x--) {
            		if(max >= arr[x]) answer += max - arr[x];
                else
                    max = arr[x];
        
            }
            bw.write("#"+idx+" "+answer+"\n");
            idx++;
        
        }
            
            
        
        bw.flush();
        br.close();
        bw.close();
        
	}
}