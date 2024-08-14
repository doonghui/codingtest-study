class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    static int[][][] map;
    static int x;
    static int y;
    static int count =0;
    public int solution(String dirs) {
        int answer = 0;
        
        // 처음 위치
         x = 5;
         y = 5;
        map = new int[11][11][4];
        
        for(int i =0;i<dirs.length();i++) {
            char c = dirs.charAt(i);
            if(c == 'U') move(0);
            else if(c == 'D') move(1);
            else if(c == 'R') move(2);
            else if(c == 'L') move(3);
        }
        
        
        answer = count;
        
        return answer;
    }
    
    static void move(int idx) {
        int nx = x + dx[idx];
        int ny = y + dy[idx];
        
        System.out.print(nx+" "+ny+"=");
        
        if(nx < 0 || nx > 10 || ny < 0 || ny > 10) { // 범위 벗어날 때
            System.out.print("nop! || ");
            return;    }
        
               int reverseIdx = 0;
            if(idx == 1 || idx == 3) {
                reverseIdx = idx-1;
            } else {
                reverseIdx = idx+1;
            }
        
        
        if(map[nx][ny][idx] == 0 && map[x][y][reverseIdx] == 0) {
     
            count +=1;
            map[nx][ny][idx] = 1;
            map[x][y][reverseIdx] = 1;
                        System.out.print("new || ");
         
        }else {
            System.out.print("old || ");
        }      
        x = nx;
        y = ny;
        
        
        
        
    }
}