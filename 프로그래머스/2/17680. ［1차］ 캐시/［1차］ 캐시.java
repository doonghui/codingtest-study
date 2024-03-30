import java.util.*;


class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();
   
        for(int j = 0;j <cities.length;j++) {
             if(cache.contains(cities[j].toLowerCase())) {
                answer +=1;
                 cache.remove(cities[j].toLowerCase());
                 cache.add(cities[j].toLowerCase());
            } else {
                cache.add(cities[j].toLowerCase());
                if(cache.size() > cacheSize) {
                    cache.remove(0);
                }
                answer +=5;
            }
            
            
        }
        
        
        
        
        
        return answer;
    }
}