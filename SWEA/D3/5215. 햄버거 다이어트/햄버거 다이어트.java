import java.util.*;
import java.io.*;



class Food implements Comparable<Food> {
	int taste;
    int cal;
    
    public Food(int taste, int cal) {
    this.taste = taste;
    this.cal = cal; }
    
    @Override
    public int compareTo(Food fo) {
    	return fo.cal - this.cal;
 
    }

}

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1 ; t <=T;t++) {
            st = new StringTokenizer(br.readLine()," ");
        	int N =  Integer.parseInt(st.nextToken());
        	int L =  Integer.parseInt(st.nextToken());
            ArrayList<Food> food = new ArrayList<>();
            
            for(int i =0;i<N;i++) {
                st = new StringTokenizer(br.readLine()," ");
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
                food.add(new Food(a,b));
            }
            
            Collections.sort(food);
            
            int[] dp = new int[L+1];
    //        Arrays.fill(dp,-1);
      //      dp[0] = 0;
            
            for(int j = 0;j<N;j++) {
                int ta = food.get(j).taste;
                int ca = food.get(j).cal;
            
                if(ca > L) continue;		// 칼로리가 최대 칼로리보다 클 때
                	
                for(int n = L; n >=ca;n--) {
                	dp[n] = Math.max(dp[n], dp[n-ca] + ta);
                }
  
            }
            
                
                
            Arrays.sort(dp);
            
        
            bw.write("#"+t+" "+dp[dp.length-1]+"\n");

            
        
        
        
        }
        
        
        bw.flush();
        br.close();
        bw.close();
	}
}