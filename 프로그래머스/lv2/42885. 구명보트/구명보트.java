import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
       Arrays.sort(people);
       int sum =0;
        
        int st = 0;
        int end = people.length -1;
      while(st <= end) {
               if(people[st] + people[end] <= limit) {
                st++;
            } 
          end--;
			answer++;
      }
       
                 return answer;

        }
        
    
}