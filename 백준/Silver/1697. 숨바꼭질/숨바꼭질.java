import java.util.*;

public class Main {
    int N, K;
    int visited[] = new int[100001];
    

    void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();        
    }

    void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(N);
        visited[N] = 1;
        
        while(!Q.isEmpty()) {
            int now = Q.poll();

            for (int i=0; i<3; i++) {
                int next;
                if (i == 0) {
                    next = now + 1;
                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if (next == K) {
                    System.out.println(visited[now]);
                    return;
                }

                if (next < 0 || next > 100000) continue;
                if (visited[next] != 0) continue;

                Q.offer(next);
                visited[next] = visited[now] + 1;
            }
        }
    }

    int count = 0;
    void Solve() {
        if (N == K)
            System.out.println(0);// 반례
        else
            BFS();
    }
    
	public static void main(String[] args) {
		Main m = new Main();
        m.InputData();
        m.Solve();
	}
}