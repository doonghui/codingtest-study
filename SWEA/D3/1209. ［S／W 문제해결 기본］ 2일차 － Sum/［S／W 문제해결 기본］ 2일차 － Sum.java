import java.util.*;
import java.io.*;




class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int t = 1 ; t <=10;t++) {
            st = new StringTokenizer(br.readLine()," ");
        	int[][] map = new int[100][100];
             
            for(int i =0;i<100;i++) {
              st = new StringTokenizer(br.readLine()," ");
                for(int j =0;j<100;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                }
          
            }
            
            int max = 0;
            int count =0;
              for(int x =0;x<100;x++) {
                  count = 0;
                for(int y =0;y<100;y++) {
                	count += map[x][y];
                }
                              max = Math.max(max,count);
            }
            
            
              for(int x =0;x<100;x++) {
                               count =0;
                for(int y =0;y<100;y++) {
                	count += map[y][x];
                }
              max = Math.max(max,count);
            }
            
            
            count =0;
              for(int x =0;x<100;x++) {
                count += map[x][x];
            }
                         max = Math.max(max,count);

            
                 count =0;
              for(int x =99;x>=0;x--) {
                count += map[99-x][x];
            }
           
            max = Math.max(max,count);
            
        bw.write("#"+t+" "+max+"\n");

            
        
        
        
        }
        
        
        bw.flush();
        br.close();
        bw.close();
	}
}