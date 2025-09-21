import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        
        String[] str = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String st: str) {
            int num = Integer.parseInt(st);
            
            max = Math.max(max,num);
            min = Math.min(min,num);
            
            
            
        }
        
        
        
        return min + " "+ max;
    }
}