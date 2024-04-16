import java.util.*;

// 11,16,19,20 실패
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // LRU 알고리즘 : 가장 오랫동안 참조되지 않은 페이지를 교체하는 기법
        
        ArrayList<String> cache = new ArrayList<>();
        for(int i=0;i<cities.length;i++) cities[i] = cities[i].toLowerCase();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        boolean flag;
        
        int idx = 0;
        // 원인 : 처음 캐시에 넣고나서 같은 도시가 또 나타날 때
        while(true) {
            if(cache.size() == cacheSize || idx >= cities.length) break;
            flag = false;
           for(int n = 0;n<cache.size();n++) {
               if(cities[idx].equals(cache.get(n))) {
                   cache.remove(cache.get(n));
                   answer++;
                   flag = true;
                   break;
               }
           }
            if(!flag) {
                answer += 5;
            }
            cache.add(cities[idx]);
            idx++;
        }
        
        
        for(int j = idx;j<cities.length;j++) {
            String city = cities[j];
            flag = false;
            for(int k =0;k<cache.size();k++) {
                if(city.equals(cache.get(k))) {
                    cache.remove(cache.get(k));
                    answer++;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                cache.remove(0);
                answer += 5;
            }
            cache.add(city);
        }
        
        
        
        return answer;
    }
}