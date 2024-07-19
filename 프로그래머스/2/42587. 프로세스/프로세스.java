import java.util.*;

class Priority {
    int num;
    int pri;
    
    public Priority(int num,int pri) {
        this.num = num;
        this.pri = pri;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Priority> q = new LinkedList<>(); 
        for(int i =0;i<priorities.length;i++) {
            q.add(new Priority(i,priorities[i]));
        }
        
        Arrays.sort(priorities);
        
        boolean flag = false;
        int idx = priorities.length-1;
        while(true) {
            Priority p = q.poll();
            
            if(p.pri < priorities[idx]) {
                q.add(p);
            } else {
                idx -=1;
                answer++;
                if(p.num == location) break;
            }
            
        }
        
        
        
        
        return answer;
    }
}