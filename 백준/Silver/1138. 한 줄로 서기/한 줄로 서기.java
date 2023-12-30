import java.io.*;
import java.util.*;

class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] answer = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int idx = 1;
            while (true) {
                if (answer[idx] == 0 && arr[i] == 0) {
                    answer[idx] = i;
                    break;
                } else if(answer[idx] == 0) arr[i]--;           // 나보다 큰 수가 있을 때
                idx++;
            }
        }

        for (int ans : answer) {
            if(ans == 0) continue;
            bw.write( ans + " ");
        }


        br.close();
        bw.flush();
        br.close();
    }




}








