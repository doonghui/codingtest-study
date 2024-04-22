import java.util.*;
import java.io.*;
class Solution
{
    static int T,N,M;
	public static void main(String args[]) throws Exception
	{
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for(int idx = 1; idx<=T;idx++) {
        
            st = new StringTokenizer(br.readLine()," ");
            
            N = Integer.parseInt (st.nextToken());
            M = Integer.parseInt (st.nextToken());
            int[][] map = new int[N][N];
            for(int i =0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0;j<N;j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            
            }
            }
            
            int answer = solve(map);
        
        bw.write("#"+idx+" "+answer+"\n");
        
        }
        
        bw.flush();
        br.close();
        bw.close();
       
        
        
	}
    static int solve(int[][] map) {
    		
        int max = 0;
        for(int i =0;i<N;i++) {
            for(int j =0;j<N;j++) {
                int cnt =0;
      	if(i+M > N || j+M > N) break;
        for(int x = i;x<i+M;x++) {
        		for(int y = j; y<j+M;y++) {
                cnt += map[x][y];
                
                }
        }
                        max = Math.max(max,cnt);
            }
    
        }
    
    
    return max;
    }
    
}