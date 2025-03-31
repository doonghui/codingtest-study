import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

       int count = 1;
       boolean flag = false;
       char lastChar = 'c';
        int number = 0;
        Map<String,Integer> map = new HashMap<>();
        
        
        
        for(int i =0;i<words.length;i++) {
            String word = words[i];
            if(i != 0 && i % n == 0) count++;
            if(i == 0) map.put(word,1);
            else {
                
            if(map.containsKey(word)) {
                flag = true;
                number = i % n +1;
                break;
            }
            if(word.charAt(0) != lastChar) {
                flag = true;
                number = i % n +1;
                break;
            }
            
                
            map.put(word,1);    
                
            }
            
            lastChar = word.charAt(word.length()-1);
        }
        
        if(flag) {
            answer[0] = number;
            answer[1] = count;
        }

        return answer;
    }
}