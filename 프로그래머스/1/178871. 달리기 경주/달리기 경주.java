import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        

        
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<Integer,String> ranking = new HashMap<>();
        
        for(int i =0;i<players.length;i++) {            // 1등부터 map에 저장
            map.put(players[i],i+1);
            ranking.put(i+1,players[i]);
        }
        
        for(String call : callings) {
            int rank = map.get(call);
            if(rank != 1) {
                String change = ranking.get(rank-1);
                map.put(call,rank-1);
                ranking.put(rank-1,call);          
                map.put(change,rank);
                ranking.put(rank,change);  
            }
            
        }
        
        
        int s = 1;
        String[] answer = new String[map.size()];
        int idx =0;
        while(idx < map.size()) {
            answer[idx] = ranking.get(s);
            
            s++;
            idx++;
           
            
            
        }
        
        
        
        
     
    

        return answer;
    }
}