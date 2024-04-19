import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
	int num;
    int cost;
    
    public Point(int num,int cost) {
    this.num = num;
        this.cost = cost;
    
    }
    @Override
    public int compareTo(Point po) {
        if(po.cost == this.cost) return po.num - this.num;
    return po.cost - this.cost;
    
    }


}


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
        	int N = Integer.parseInt(br.readLine());
            ArrayList<Point> p = new ArrayList<>();
            int[] arr = new int[101];
            
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i =0;i<1000;i++) {
            	int num = Integer.parseInt(st.nextToken());
             arr[num]++;
            }
            
            for(int j =0;j<=100;j++) {
            p.add(new Point(j,arr[j]));
            
            }
        
        Collections.sort(p);
            
            bw.write("#"+N+" "+p.get(0).num+"\n");
        
        }
        
        bw.flush();
	}
}