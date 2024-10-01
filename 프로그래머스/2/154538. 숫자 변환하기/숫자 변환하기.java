import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        HashSet<Integer> set= new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[]o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
            
            // 5,7,9,10,11,14,15,16 틀림..
            //     public int compare(int[] o1, int[]o2) {
            //     if(o1[1] == o2[1]) return o1[0] - o2[0];
            //     return o1[1] - o2[1];
            // }
            
        });
        q.add(new int[]{x,0});
        while(!q.isEmpty()) {
            int[] num = q.poll();
            
            if(num[0] == y) return num[1];
            
            if(num[0] > y) continue;
            
           if(!set.contains(num[0])) {
               set.add(num[0]); 
               
    
              q.add(new int[]{num[0]+n,num[1]+1});
              q.add(new int[]{num[0]*2,num[1]+1});
              q.add(new int[]{num[0]*3,num[1]+1});
               
           }
            
        }
        
        return -1;
    }
}