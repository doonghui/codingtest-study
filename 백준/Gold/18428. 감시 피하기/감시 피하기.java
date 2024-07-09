import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	static int N;
	static char[][] map;
	static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
	static ArrayList<Pair> list = new ArrayList();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'S') {
					list.add(new Pair(i,j));
				}
			}
		}

		dfs(0);
		System.out.println("NO");
		
		
	
	}
	public static void dfs(int wall) {
		if(wall==3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(wall+1);
					map[i][j] = 'X';
				}
			}
		}
		
	}
	public static void bfs() {
		Queue<Pair> queue = new LinkedList();
		char[][] map_copy = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_copy[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map_copy[i][j] == 'T') {
					queue.add(new Pair(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = dir[k][0] + p.x;
				int ny = dir[k][1] + p.y;
				
				while(isInside(nx,ny)) {
					if(map_copy[nx][ny] != 'O') {
						visited[nx][ny] = true;			
						nx = nx+dir[k][0];
						ny = ny+dir[k][1];

					}else break;
				}
			}
		}
		
		if(cath(visited)) {
			System.out.println("YES");
			System.exit(0);
		}
		
	}
	public static boolean cath(boolean[][] visited) {
		for(Pair p : list) {
			if(visited[p.x][p.y] == true) return false;
		}
		return true;
		
	}
	public static boolean isInside(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}
}
class Pair{
	int x, y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}