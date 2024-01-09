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
        int lt =0;
        int rt =0;
        long max = arr[lt];
        long sum = arr[lt];
        
        while(rt < arr.length-1) {
            rt++;
            if(sum < 0) {
                lt = rt;
                sum = arr[rt];
            } else {
                sum += arr[rt];
            }            
            max = Math.max(max,sum);  
        }
        
        while(lt < rt) {
            sum -= arr[lt];
            lt++;
            max = Math.max(max,sum);
        }
        
//         for(int i = 1; i<arr.length;i++) {
//             if(arr[i] >=0 && arr[i-1] >= 0) sum += arr[i];
//             else if(arr[i] >= 0 && arr[i-1] <0) sum = arr[i];
//             else if(arr[i] < 0 && arr[i-1] <0) sum = Math.max(sum,arr[i]);
//             max = Math.max(max,sum);
//         }


        
        return max;
    }    

}