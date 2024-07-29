import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());
			
			// 입력 받은 건물의 높이보다 작거나 같은 건물은 스택에서 삭제 -> 이전에 들어온 빌딩에서 새로운 빌딩을 확인할 수 없는 경우(높이가 더 높기 때문에 불가능)
			while (!stack.isEmpty() && stack.peek() <= height) {
				stack.pop();
			}
			
			result += stack.size();
			stack.push(height);
		}
		
		System.out.println(result);
	}

}