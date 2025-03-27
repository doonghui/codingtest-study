import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        

        
        //회전작업
        for(int j =0;j<s.length();j++) {
            
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            int idx = j;
            int count = 0;
            while(true) {
                if(j == s.length()) j = 0;
                if(count == s.length()) break;
                stack1.add(s.charAt(j));
                j++;
                count++;
                
            }
            
            // 맞는지 안맞는지 찾기
            boolean flag = false;
            while(!stack1.isEmpty()) {
                char c = stack1.pop();
                if(stack2.isEmpty()) stack2.push(c);
                else if(c == '{') {
                    if(stack2.pop() != '}') {
                        flag = true;
                        break;
                    }
                }          else if(c == '(') {
                    if(stack2.pop() != ')') {
                        flag = true;
                        break;
                    }
                }          else if(c == '[') {
                    if(stack2.pop() != ']') {
                        flag = true;
                        break;
                    }
                } else {
                    stack2.push(c);
                }

            }
            
            if(!flag && stack2.isEmpty()) answer++;
            
            
        }
        
        
        
        
        return answer;
    }
}