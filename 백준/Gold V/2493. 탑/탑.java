import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Stack<int[]> stack = new Stack<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < N; j++) {
            int num = arr[j];
            while (true) {
                if (!stack.isEmpty()) {
                    if (stack.peek()[1] > num) {
                        bw.write(stack.peek()[0] + " ");
                        stack.add(new int[]{j + 1, num});
                        break;
                    } else {
                        stack.pop();
                    }


                } else {
                    bw.write("0 ");
                    stack.add(new int[]{j + 1, num});
                    break;
                }
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }
}

