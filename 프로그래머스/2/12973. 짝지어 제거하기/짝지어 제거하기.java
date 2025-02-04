import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
       Stack<Character> stack = new Stack<>();
        
        
        
        int idx = 0;
        
        while(idx < s.length()) {
            
            if(!stack.isEmpty() && stack.peek() == s.charAt(idx)) {
                stack.pop();
            } else {
                stack.push(s.charAt(idx));
            }
            idx++;
        }
        
        if(stack.isEmpty()) answer = 1;
        
        
        
        

        return answer;
    }
}