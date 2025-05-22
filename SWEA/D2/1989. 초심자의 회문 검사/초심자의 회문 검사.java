
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());


		for(int i = 1;i<=n;i++) {
			String str = br.readLine().trim();
			boolean flag = false;
			for(int j =0;j<str.length()/2;j++) {
				if(str.charAt(j) != str.charAt(str.length() - j-1)) {
					flag = true;
					break;
				}
			}

			if(flag) {
				bw.write("#"+i+" 0\n");
			} else {
				bw.write("#"+i+" 1\n");
			}

		}

		bw.flush();
		br.close();
		bw.close();

	}

}
