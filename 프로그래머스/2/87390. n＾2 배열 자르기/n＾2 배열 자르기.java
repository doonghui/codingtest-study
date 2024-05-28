import java.util.*;

class Solution {
    static long[][] arr;
    public int[] solution(int n, long left, long right) {

        ArrayList<Long> ans = new ArrayList<>();

        
        // 1234
        // 2334
        // 3334
        // 4444

        // int le = (int)left;
        // int ri = (int)right;
        
        for(long x = left;x<=right;x++) {
            ans.add(Math.max(x/n,x%n) +1);
            // if(x / n <= x % n) {
            //     ans.add((int)(x %n) +1);
            // } else
            //     ans.add((int)(x/n)+1);
        }
        
        int[] answer = new int[ans.size()];
        for(int l = 0;l<answer.length;l++) {
            
            answer[l] = ans.get(l).intValue();
            
        }

        
        
        return answer;
    }
    

    
    
}