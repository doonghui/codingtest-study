
import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dif = new int[N - 1];

		for (int j = 0; j < N - 1; j++) {
			dif[j] = arr[j + 1] - arr[j];
		}

		Arrays.sort(dif);

		int ans = 0;
		for (int k = 0; k < N - K; k++) {
			ans += dif[k];
		}

		bw.write(ans + "");

		bw.flush();
		br.close();
		bw.close();
	}

}