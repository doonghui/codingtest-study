import java.io.*;
import java.util.*;


class Solution
{
    
    static int N,K,answer;
	public static void main(String args[]) throws Exception
	{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        int idx = 1;
        for(int t = 1; t<=T;t++) {
                        st = new StringTokenizer(br.readLine()," ");
             N = Integer.parseInt(st.nextToken());
             K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
             
            st = new StringTokenizer(br.readLine()," ");
            for(int i =0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
      
             answer = 0;
      		// j 개 선택했을 때 가능한지 확인
            for(int j = 1; j<=N;j++) {	
            	check(j,0,arr,0,0);
            
            
            }
          bw.write("#"+t+" "+answer+"\n");
        }
            
            
        
        bw.flush();
        br.close();
        bw.close();
        
	}
    
    static void check(int n,int cnt,int[] arr,int sum,int idx) {
    
        if(n == cnt) {
        if(sum == K) answer++;
        return;
        } 
    
    	for(int i = idx; i<N;i++) {
        	if(sum + arr[i] > K) continue;
            check(n,cnt+1,arr,sum+arr[i],i+1);
        }
    
    
    
    }
    
    
}