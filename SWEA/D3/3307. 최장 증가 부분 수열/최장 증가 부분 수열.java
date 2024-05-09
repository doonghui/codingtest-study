import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1;t<=T;t++) {
        	int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            
            st = new StringTokenizer(br.readLine()," ");
            for(int i =0;i<N;i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.fill(dp,1);
            for(int x = 1; x<N;x++) {
            	
                for(int y = x-1; y>=0;y--) {
                    if(arr[x] > arr[y]) dp[x] = Math.max(dp[x],dp[y] +1);
                
                }
            }
            Arrays.sort(dp);
        
            bw.write("#"+t+" "+dp[N-1]+"\n");
        
        }
        
        bw.flush();
        br.close();
        bw.close();
        
        
	}
}