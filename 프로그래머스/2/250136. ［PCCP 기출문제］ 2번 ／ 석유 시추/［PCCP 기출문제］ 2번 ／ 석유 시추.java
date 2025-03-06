import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y =y;
        
    }
}


class Solution {
    static Map<Integer,Integer> map;
    static int cnt;
    static boolean[][] check;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    public int solution(int[][] land) {
        int answer = 0;
        map = new HashMap<>();
        check = new boolean[land.length][land[0].length];
        
        int n = 2;
        for(int i =0;i<land.length;i++) {
            for(int j =0;j<land[0].length;j++) {
                if(land[i][j] == 1 && !check[i][j]) {
                    bfs(land,i,j,n);
                    // map.put(n,cnt);
                    n++;

                }
            }
        }
        

        
        int max = 0;
        for(Integer count : map.values()) {
            max = Math.max(max,count);
            // System.out.print(count+" / ");
        }
        
        
        
        return max;
    }
    
    
    
    static void bfs(int[][] land,int x,int y,int n) {
        
        Set<Integer> set = new HashSet<>();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        check[x][y] = true;
        land[x][y] = n;
        set.add(y);
        cnt = 1;

        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            for(int i =0;i<4;i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length) continue;
                if(land[nx][ny] == 1 && !check[nx][ny]) {
                    check[nx][ny] = true;
                    land[nx][ny] = n;
                    cnt++;
                    set.add(ny);
                    q.add(new Point(nx,ny));
                }
                
            }
        }
        
        for(int yy : set) {
            map.put(yy,map.getOrDefault(yy,0)+cnt);
        }
        
    }
}