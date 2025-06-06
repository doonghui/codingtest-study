
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		StringBuilder builder = new StringBuilder();

		int idx = 0;
		for (int j = 1; j <= n; j++) {
			stack.push(j);
			builder.append("+\n");

			while (!stack.isEmpty() && stack.peek() == arr[idx]) {
				stack.pop();
				builder.append("-\n");
				idx++;
			}
		}

		boolean flag = false;
		while (!stack.isEmpty()) {
			if (stack.pop() != arr[idx]) {
				bw.write("NO");
				flag = true;
				break;
			}
			builder.append("-\n");
			idx++;
		}

		if (!flag) {
			bw.write(String.valueOf(builder));

		}

		bw.flush();
		bw.close();
		br.close();

	}

}
