import java.util.*;

class Priority {
    int idx;
    int pri;
    
    public Priority(int idx, int pri) {
        this.idx = idx;
        this.pri = pri;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        
        ArrayList<Priority> arr = new ArrayList<>();
        
        for(int i =0;i<priorities.length;i++) {
            arr.add(new Priority(i,priorities[i]));
        } 
        
        
        while(true) {
            Priority p = arr.get(0);
            boolean flag = false;
            for(int j = 1;j<arr.size();j++) {
                if(arr.get(j).pri > p.pri) {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                arr.remove(0);
                arr.add(p);
            } else {
                arr.remove(0);
                answer++;
            if(p.idx == location)
                break;
            }
            
            
            
        }
        
        
        // 1.hashMap
        // 2. 
        
        // 맨 앞에 꺼내고
        // 뒤에꺼랑 비교해보고 더 큰게 없으면 완전히 꺼낸다 
        // 있으면 다시 뒤에 넣는다
        // 만약 꺼낸 순서가 location 과 같다면 바로 return
        
        
        return answer;
    }
}
