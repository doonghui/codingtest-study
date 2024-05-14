
import java.util.*;
import java.io.*;

class Solution {
	static int N, K;
	static int ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int lt = 0;
			int ans = Integer.MAX_VALUE;
			for (int rt = K-1; rt < N; rt++) {
				ans = Math.min(ans,arr[rt]-arr[lt]);
				lt++;
			}
			

			bw.write("#" + t + " " + ans + "\n");

		}

		bw.flush();
		br.close();
		bw.close();
	}



}
