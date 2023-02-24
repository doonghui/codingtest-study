import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
		
        Stack<Character> stack = new Stack<>();
            for(char x : s.toCharArray()){
            if(x == '(')
                stack.push(x);
            
            if(stack.isEmpty())
                return answer;
               
            if(x == ')')
                stack.pop();
        }
        
        if(stack.isEmpty())
            answer = true;

        
        

        return answer;
    }
}