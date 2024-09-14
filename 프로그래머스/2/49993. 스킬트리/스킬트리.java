import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashMap<Character,Boolean> map = new HashMap<>();
        

        
        
        for(String sk : skill_trees) {
                    for(char c : skill.toCharArray()) {
            map.put(c,false);
        }
            
            
            boolean flag = false;
            for(int i =0;i<sk.length();i++) {
                char ch = sk.charAt(i);
                if(map.containsKey(ch)) {
                    int idx = 0;
                    while(skill.charAt(idx) != ch) {
                        if(!map.get(skill.charAt(idx))) {
                            flag = true;
                            break;
                        }
                        idx++;
                    }
                    
                if(flag) break;
                    else
                        map.put(ch,true);
                }
                
            }
            
            if(!flag) answer++;
            
        }
        
        
        
        // 스킬트리안에 c 하나가 스킬에 없음 무시
        // 있을때 ~ -> 스킬의 순서에 맞는지 확인해봐야함
        
        // 
        
        
        
        return answer;
    }
}