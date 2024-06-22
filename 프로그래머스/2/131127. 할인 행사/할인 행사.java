import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        // 0일차(10개 먼저 map 에 넣기)
        for(int i =0;i<10;i++) {
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
        }
        // 0~ N일차까지 map에 +,- 하고 확인하면서 맞으면 count++ 하기
        int count = 0;
        for(int day = 0;day<discount.length;day++) {
            boolean flag = false;
            for(int j =0;j<want.length;j++) {
                if(!map.containsKey(want[j]) || map.get(want[j]) < number[j]) {
                    flag = true;
                    break;
                } 
            }
            if(!flag) count++;
            
            map.put(discount[day],map.get(discount[day])-1);
            if(day+10 < discount.length) map.put(discount[day+10],map.getOrDefault(discount[day+10],0)+1);
        }    
        
        System.out.print(map);
        
            
            
        return count;
    }
}