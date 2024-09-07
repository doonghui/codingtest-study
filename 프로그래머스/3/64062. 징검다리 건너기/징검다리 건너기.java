import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        int mid =  (left+right) /2;
        while(left <= right) {
            if(road(stones,mid,k)) {
                left = mid +1;
            } else {
                right = mid -1;
            }
            
            mid = (left+right) /2;  
            }
                
    
        
    
        
    
        
        return mid;
    }
    

    
    static boolean road(int[] stones, int friends, int k) {
        int count = 0;
        for (int j = 0; j < stones.length; j++) {
            if (stones[j] - friends < 0) count++;
            else count = 0;

            if (count == k) return false;
        }


        return true;


    }
    
    
}