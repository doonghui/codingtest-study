
import java.util.*;
import java.io.*;

class Solution {
	static int N;
	static int ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			char[] bits = str.toCharArray();
			char[] ch = new char[str.length()];

			int ans = 0;
			for (int i = 0; i < str.length(); i++) {
				if (bits[i] == '1') {
					ans++;
					int idx = i;
					while (idx < str.length()) {

						if (bits[idx] == '1')
							bits[idx] = '0';
						else
							bits[idx] = '1';
						idx++;
					}

				}
				String tmp = bits.toString();
				if (tmp.equals(str))
					break;

			}

			bw.write("#" + t + " " + ans + "\n");

		}

		bw.flush();
		br.close();
		bw.close();
	}

}

//6 2
//1 2 4 8 9 12

// 1 2 4 1 3