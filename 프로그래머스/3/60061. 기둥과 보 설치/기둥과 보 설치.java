import java.util.*;

class Bridge implements Comparable<Bridge>{
    int x;
    int y;
    int type;

    Bridge(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    @Override
    public int compareTo(Bridge br) {
        if(this.x == br.x) {
            if(this.y == br.y)
                return this.type - br.type;
                else
                    return this.y - br.y;
        } else
            return this.x - br.x;
    }
}


class Solution {
    static int[][][] map;



    public  int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        map = new int[n+1][n+1][2];


        for (int[] build : build_frame) {
            build(build[0], build[1], build[2], build[3], n);
        }

        Queue<Bridge> bridges = new LinkedList<>();
        for(int i =0; i<map.length;i++) {
            for(int j =0; j<map[i].length;j++){
                for(int k =0; k<2;k++) {
                    if(map[i][j][k] == 1) bridges.add(new Bridge(i,j,k));
                }
            }
        }
        answer = new int[bridges.size()][3];
        int cnt = 0;
        while(!bridges.isEmpty()){
            Bridge bridge = bridges.poll();
            answer[cnt][0] = bridge.x;
            answer[cnt][1] = bridge.y;
            answer[cnt][2] = bridge.type;
            cnt++;
        }

        return answer;
    }

    static void build(int x, int y, int type, int cr, int n) {
        // 1. 설치, 삭제 해본다.
        // 2. 검증
        // 3.불가능하면 다시 복구, 가능하면 그대로 진행
        if (cr == 1) {
            if (check(x, y, type,n)) {
                map[x][y][type] = 1;
            }
        } else {
            map[x][y][type] = 0;                     // 삭제
            if(type == 0)  {                        // 기둥 삭제시
                if(y < n-1 && map[x][y+1][0]== 1 && !check(x,y+1,0,n)) map[x][y][type] = 1;                           // 내 기둥 위에 또 기둥이 있을 때 얘가 설치가 가능한지
                else if(x < n && map[x][y+1][1] == 1 && !check(x,y+1,1,n)) map[x][y][type] = 1;                            // 내 기둥에 보가 있을 때 보를 설치가능한지
                else if(x>0 && map[x-1][y+1][1] == 1 && !check(x-1,y+1,1,n)) map[x][y][type] =1;


            } else {                                // 보 삭제시
                if(map[x][y][0]== 1 && !check(x,y,0,n)) map[x][y][type] = 1;                        // 보 위에 기둥이 있을시
                else if(map[x+1][y][0] == 1 &&  !check(x+1,y,0,n)) map[x][y][type] = 1;                 // 보 오른쪽 위에 기둥이 있을 시
                else if(x > 0 && map[x-1][y][1] == 1 && !check(x-1,y,1,n)) map[x][y][type] = 1;                    // 보의 왼쪽에 다른 보가 있을 시
                else if(x <n-1 && map[x+1][y][1] == 1 && !check(x+1,y,1,n)) map[x][y][type] = 1;                      // 보의 오른쪽에 다른 보가 있을 시
            }

        }


    }

    static boolean check(int x, int y, int type, int n) {
        if (type == 0) {                   // 기둥
            if (y == 0) return true;                                        // 바닥위에 있을 때
            else if (map[x][y-1][0] == 1) return true;                         // 또다른 기둥 위에 있을 때
            else if (x < n && map[x][y][1] == 1) return true;                         // 보의 한쪽 끝 부분 위에 있을 때
            else if (x > 0 && map[x-1][y][1] == 1) return true;               // 보의 한쪽 끝 부분 위에 있을 때

        } else {                          // 보
            if (map[x][y-1][0] == 1 || map[x + 1][y - 1][0] == 1)
                return true;                                 // 한쪽 끝 부분이 기둥 위에 있을 때
            else if ((x > 0 && map[x-1][y][1] == 1) && (x < n-1 && map[x+1][y][1] == 1))
                return true;     // 양쪽 끝 부분이 다른 보와 동시에 연결되어 있을 때


        }


        return false;
    }
}