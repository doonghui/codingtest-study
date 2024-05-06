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
        	st = new StringTokenizer(br.readLine()," ");
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
            int[] dis = new int[K+1];
            
            for(int i =0;i<N;i++) {
              st = new StringTokenizer(br.readLine()," ");
              int v = Integer.parseInt(st.nextToken());				// 부피
              int c = Integer.parseInt(st.nextToken());				// 가치
                
              for(int x = K;x>=v;x--) {
              dis[x] = Math.max(dis[x],dis[x-v] + c);
              }
            }
            
            Arrays.sort(dis);
            
            bw.write("#"+t+" "+dis[K]+"\n");
        
        
        }
        
        bw.flush();
        br.close();
        bw.close(); 
	}
}