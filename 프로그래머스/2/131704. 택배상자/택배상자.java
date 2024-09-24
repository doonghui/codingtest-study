import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
     
        Stack<Integer> stack = new Stack<>();
     
        int idx = 0;
      for(int n = 1;n<=order.length;n++) {

              stack.push(n);
    
          
          while(!stack.isEmpty() && stack.peek() == order[idx]) {
              stack.pop();
              answer++;
              idx++;
          }
          
          
      }
        return answer;
    }
}