import java.util.*;

// 누적합
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] upDownBoard = new int[board.length+1][board[0].length+1];
        
        for(int i= 0;i<skill.length;i++) {
            int fromX = skill[i][1];
            int fromY = skill[i][2];
            int toX = skill[i][3];
            int toY = skill[i][4];
            int degree = skill[i][5];
            
            
            if(skill[i][0] == 1) degree *= -1;
            
            upDownBoard[fromX][fromY] += degree;
            upDownBoard[fromX][toY+1] += (degree * -1);
            upDownBoard[toX+1][fromY] += (degree * -1);
            upDownBoard[toX+1][toY+1] += degree;
               }      
            
            // 가로 누적합
            for(int x =0;x<board.length+1;x++) {
                for(int y = 0;y<board[0].length;y++) {
                    upDownBoard[x][y+1] += upDownBoard[x][y];
                }
            }
            
            // 세로 누적합
            for(int y =0;y<board[0].length+1;y++) {
                for(int x = 0;x<board.length;x++) {
                    upDownBoard[x+1][y] += upDownBoard[x][y];
                }
            }
   
            
            
        for(int x = 0; x<board.length;x++) {
            for(int y =0;y<board[0].length;y++) {
                int sum =board[x][y] + upDownBoard[x][y];
            if( sum>0) answer++; 
            }
        }
            

    
        
        
        
        return answer;
    }
}