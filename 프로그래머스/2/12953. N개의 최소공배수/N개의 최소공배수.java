import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        Arrays.sort(arr);
        
        ArrayList<Integer> n = new ArrayList<>();
        
        int big = arr[arr.length-1];
        int idx = arr.length-1;
        
       
        while(true) {
             boolean flag = false;
            for(int i =0;i<=idx;i++) {
                if(big % arr[i] != 0) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                answer = big;
                break;
            }
            big++;
        }
        
        
        
        
        return answer;
    }
}