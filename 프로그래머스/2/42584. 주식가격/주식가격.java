import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 테스트5 시간초과 남 -> 스택2개 이용했을 때.. 1개로 하면가능 다시 풀어야 함
        Stack<Integer> stack = new Stack<>();       // 

        for(int i = 0;i<prices.length;i++) {
            answer[i] = prices.length-1-i;      // 가격이 떨어지지않을 때 최대 기간 
            while(!stack.isEmpty()) {
                if(prices[stack.peek()] <= prices[i]) break;        // 가격이 안떨어지면 그냥 나가기
                
                    int idx = stack.pop();
                    answer[idx] =i - idx;
            }
            
            stack.push(i);
        
        }

        return answer;
    }
}