import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
       answer = binarySearch(n,times,times[0],(long)n *times[times.length-1]);
        
        return answer;
    }
    
    
    static long binarySearch(int n,int[] times,long lt, long rt) {
        
        long ans = rt;
        while(lt <= rt) {
            long sum =0;
            long mid = (lt+rt) / 2;
            for(int time : times) {
                sum += mid / time;
            }
            if(sum >= n) {
                rt = mid - 1;
                ans = mid;
            } else {
                lt = mid + 1;
            }
            
            
        }
        
        return ans;
    }
}