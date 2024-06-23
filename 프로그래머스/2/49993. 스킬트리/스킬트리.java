import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
         int answer = 0;

        HashMap<Character,Integer> map = new HashMap<>();




        for(int j =0;j<skill_trees.length;j++) {
            for(int i=0;i<skill.length();i++) {
                map.put(skill.charAt(i),0);
            }
            boolean flag = false;
            for(int k =0;k<skill_trees[j].length();k++) {
                char ch = skill_trees[j].charAt(k);
                int idx = 0;
                if(map.containsKey(ch)) {
                    while(skill.charAt(idx) != ch) {
                        if(map.get(skill.charAt(idx)) == 0) {
                            flag = true;
                            break;
                        } else idx++;
                    }
                }

                if(flag) break;
                else
                    if(map.containsKey(ch)) map.put(ch,1);
            }

            if(!flag) answer++;


        }



        return answer;
    }
}