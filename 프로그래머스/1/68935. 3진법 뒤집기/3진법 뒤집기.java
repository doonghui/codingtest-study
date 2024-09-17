import java.util.*;

class Solution {
    public int solution(int n) {
        String three = Integer.toString(n,3);
    
    String tmp = "";
    
    for(int i = three.length()-1;i>=0;i--) {
        tmp += three.charAt(i);
    }
    
    String num = Long.parseLong(tmp) +"";    
    
    System.out.println(num);
    
    
    
    return Integer.parseInt(num,3);
    }
}