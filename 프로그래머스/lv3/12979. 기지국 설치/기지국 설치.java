import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // ArrayList<Integer> emptyApartments = new ArrayList<>();
        int startPoint;
        int endPoint = 1;
        int emptyApartments;
        
        int len = 2*w +1;
        
        for(int station : stations) {
            startPoint = station - w;
            
            emptyApartments = startPoint - endPoint;
            
            if(emptyApartments >0) {
                if(emptyApartments  % len == 0) answer += emptyApartments / len;
                    else
                        answer += (emptyApartments / len) +1;
            }
            
       
            
            endPoint = station+w+1;
        }
        
        if(endPoint <= n) {      // 마지막 기지국의 전파가 n 의 끝까지 도달하지 않은 경우
           emptyApartments =  n-endPoint+1;
            if(emptyApartments  % len == 0) answer += emptyApartments / len;
            else
                answer += (emptyApartments / len) +1;
            
        }  
        
    
      

        return answer;
    }
}