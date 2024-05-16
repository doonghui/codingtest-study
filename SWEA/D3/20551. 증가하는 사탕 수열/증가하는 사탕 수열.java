
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

			int[] arr = new int[3];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int ans = 0;


			while (arr[2] <= arr[1]) {
				arr[1]--;
				ans++;
			}
			while (arr[1] <= arr[0]) {
				arr[0]--;
				ans++;
			}

			if (arr[1] <= 1 || arr[0] <= 0)
				bw.write("#" + t + " -1\n");
			else
				bw.write("#" + t + " " + ans + "\n");

		}

		bw.flush();
		br.close();
		bw.close();
	}

}
