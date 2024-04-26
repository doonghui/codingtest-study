import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i =1;i<=N;i++) {
        	String str = i + "";
            int cnt = 0;
            for(int j = 0; j<str.length();j++) {
            	if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') cnt++;
            }
            
           if(cnt == 0) bw.write(str);
            else {
            	for(int k = 0; k<cnt;k++) {
                	bw.write("-");
            }
        }
        bw.write(" ");
        
        
	}
        bw.flush();
        br.close();
        bw.close();
}
}