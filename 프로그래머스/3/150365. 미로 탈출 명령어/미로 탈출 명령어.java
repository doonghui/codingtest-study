import java.util.*;
class Solution {
    static int[] dx = {1,0,0,-1};         // 아래,왼,오,위
    static int[] dy = {0,-1,1,0};  
    static char[] arr;
    static String ans = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        int distance = Math.abs(x - r) + Math.abs(y - c);

        if(distance > k || (k - distance) % 2 == 1) return "impossible";        // 거리가 k 보다 크거나 중복방문시 홀수면 x
        
        arr = new char[k];
        dfs(0,n,m,x,y,r,c,k);
        
        if(ans == "") answer = "impossible";
        else
            return ans;
        
        return answer;
    }
    
    
    static void dfs(int dept,int n, int m,int x, int y, int r, int c, int k) {
        
        if(k < dept + Math.abs(x - r) + Math.abs(y - c)) return;
        
        if(dept == k && x == r && y == c) {
            String tmp = new String(arr);
            // if(ans.equals("")) ans = tmp;
            // else {
            //     if(tmp.compareTo(ans) <=0) ans = tmp;
            // }
            ans = tmp;
            
            return;
        }
        if(dept == k) return;
        
        for(int i =0 ;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];        
            if(nx < 1 || nx >n || ny < 1 || ny > m) continue;
            
            char tmpChar='0';
             if(dx[i] == 1) tmpChar = 'd';
            else if(dy[i] == -1) tmpChar = 'l';
            else if(dy[i] == 1) tmpChar = 'r';
            else if(dx[i] == -1) tmpChar = 'u';
            if(!ans.equals("")) {
                if(tmpChar < arr[dept]) return;
                else
                    arr[dept] = tmpChar;
                
            } else{
                arr[dept] = tmpChar;
            }
            
            dfs(dept+1,n,m,nx,ny,r,c,k);
            
            
        }
        
        
    }
}
