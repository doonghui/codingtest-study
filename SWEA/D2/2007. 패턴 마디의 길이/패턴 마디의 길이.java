
import java.util.*;
import java.io.*;

import java.io.*;

class Solution {


	public static void main(String args[]) throws Exception {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =1;i<=N;i++) {
			String s = br.readLine();
			for(int j =1;j<s.length();j++) {
				String str = s.substring(0,j);
				String str2 = s.substring(j,j+j);
				if(str.equals(str2)) {
					bw.write("#"+i+" "+j+"\n");
					break;
				}

			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	


}
