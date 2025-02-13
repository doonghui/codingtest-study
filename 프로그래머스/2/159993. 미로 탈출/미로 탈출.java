import java.util.*;

class Solution {

    static boolean isEnd = false;
    static boolean isLever = false;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] count;
    static int answer = 0;
    public int solution(String[] maps) {
        

        // 2차원 배열에 넣고 재정의 + start 위치, end, 레버 위치 찾기
        // X:0, O:1, S:2, L:3, E:4

        int[][] map = new int[maps.length][maps[0].length()];
        count = new int[maps.length][maps[0].length()];
        for (int[] c : count) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        int sX = 0;
        int sY = 0;
        int lX = 0;
        int lY = 0;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);

                if (c == 'S') {
                    map[i][j] = 2;
                    sX = i;
                    sY = j;
                } else if (c == 'L') {
                    map[i][j] = 3;
                    lX = i;
                    lY = j;
                } else if (c == 'E') map[i][j] = 4;
                else if (c == 'X') map[i][j] = 0;
                else if (c == 'O') map[i][j] = 1;

            }
        }

        // start 위치에서 bfs로 가기
        // boolean 하나 둬서 레버당기고 끝 위치 났을때는 아예 탈출
        // 레버 안당기고 그냥 끝위치는 그냥 가기
        // 만약 끝까지 갔는데 booolean false 이면 -1 return

        // start 에서 레버까지의 최단거리
        bfs(map, sX, sY);
        if (!isEnd) return -1;

        isEnd = false;
        count = new int[maps.length][maps[0].length()];
        for (int[] c : count) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        bfs(map, lX, lY);

        // 레버에서 end까지 최단거리

        if (!isEnd) return -1;


        return answer;
    }
    
      static void bfs(int[][] map, int sX, int sY) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sX, sY});
        count[sX][sY] = 0;


        while (!q.isEmpty()) {
            int[] point = q.poll();

            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;

                if (map[nx][ny] == 0) continue;
                if (count[nx][ny] <= count[x][y] + 1) continue;

                if (count[nx][ny] > count[x][y] + 1) {
                    count[nx][ny] = count[x][y] + 1;

                    if (!isLever && map[nx][ny] == 3) {
                        answer += count[nx][ny];
                        isEnd = true;
                        isLever = true;
                        return;
                    }


                    if (isLever && map[nx][ny] == 4) {
                        answer += count[nx][ny];
                        isEnd = true;
                        return;
                    }

                    q.add(new int[]{nx, ny});
                }


            }


        }


    }
    
    
    
}

// ==> 30분