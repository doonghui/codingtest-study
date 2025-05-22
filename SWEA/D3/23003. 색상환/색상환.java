
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		Map map = new HashMap<String, Integer>();

		map.put("red", 0);
		map.put("orange", 1);
		map.put("yellow", 2);
		map.put("green", 3);
		map.put("blue", 4);
		map.put("purple", 5);

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int left = (int)map.get(st.nextToken());
			int right = (int)map.get(st.nextToken());

			if (left == right) {
				bw.write("E\n");
			} else if (left + 3 == right || left - 3 == right) {
				bw.write("C\n");
			} else if (left + 1 == right || left - 1 == right) {
				bw.write("A\n");
			} else {
				if (left == 0 && right == 5) {
					bw.write("A\n");
				} else if (left == 5 && right == 0)
					bw.write("A\n");
				else
					bw.write("X\n");
			}

		}

		bw.flush();
		br.close();
		bw.close();

	}

}
