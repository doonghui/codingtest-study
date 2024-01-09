import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        
        int[] evenArr = sequence.clone();
        int[] oddArr = sequence.clone();
        
        for(int i = 0; i<sequence.length;i++) {
            
            
            if(i % 2 == 0) evenArr[i] = sequence[i] * -1;
            else
               oddArr[i] = sequence[i] * -1;
        }
        

        
        long evenMax = sol(evenArr);
        long oddMax = sol(oddArr);
     
        answer = Math.max(evenMax,oddMax);
        
        return answer;
    }
    
    
    static long sol(int[] arr) {
        long max = arr[0];
        long sum = arr[0];
        for(int i = 1; i<arr.length;i++) {
            if(sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }   
            max = Math.max(max,sum);
        }

        return max;
    }    

}
