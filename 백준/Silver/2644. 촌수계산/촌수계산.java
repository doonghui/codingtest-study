import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, from, to, result=-1;
	static boolean[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); 
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			map[v1][v2]=map[v2][v1]=true;
		}
		
		visited = new boolean[N+1];
		dfs(from, 0);
		
		System.out.println(result);
	}

	private static void dfs(int p, int d) {
				visited[p] = true;
				if(p==to) {
			result=d;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(map[p][i] && !visited[i]) dfs(i, d+1);
		}
	}
	
}