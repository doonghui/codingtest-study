import java.util.*;

// 50, 61 .. 4~15, 23 오답    
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        
        long sum = 0;
        int lt = 0;
        int minLen = 1000001;
        
        
        // lt,rt 로 합이 k 개 이하인거 차
           for(int rt = 0;rt<sequence.length;rt++) {
            sum += sequence[rt];
            if(sum >= k) {
                while(sum >= k && lt <= rt) {
                    if(sum == k && rt-lt < minLen) {
                    minLen = rt-lt;
                    answer[0] = lt;
                    answer[1] = rt;
                    } 
                    sum -= sequence[lt];
                    lt++;
                }
                
                
            } 
                    // System.out.print(sum+" ");

       
        }
        
        
        
        
//         for(int rt = 0;rt<sequence.length;rt++) {
//             sum += sequence[rt];
//             if(sum > k) {
//                 while(sum > k || lt <rt) {
//                     sum -= sequence[lt];
//                     lt++;
//                 if(sum == k) {
//                 if(rt - lt < minLen) {
//                     minLen = rt-lt;
//                     answer[0] = lt;
//                     answer[1] = rt;
//                 }
//             }
//                 }
//             }  else if(sum == k) {
//                 if(rt - lt < minLen) {
//                     minLen = rt-lt;
//                     answer[0] = lt;
//                     answer[1] = rt;
//                 }
//             }
//                     // System.out.print(sum+" ");

       
//         }
        
        
        
        return answer;
    }
}


// 입력값 〉 [1, 2, 2, 2, 10], 1
// 기댓값 〉 [0, 0]


// 입력값 〉 [3, 24, 109, 159, 176, 255, 320, 367, 404, 919], 726
// 기댓값 〉 [0, 5]
// 실행 결과 〉 실행한 결괏값 [9,9]이 기댓값 [0,5]과 다릅니다.


// 입력값 〉 [2, 2, 2, 2, 2, 10, 10, 10, 10, 10, 10], 30
// 기댓값 〉 [5, 7]


