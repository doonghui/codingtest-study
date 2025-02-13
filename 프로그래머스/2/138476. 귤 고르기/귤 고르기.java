import java.util.*;


public class Tangerine implements Comparable<Tangerine> {
    int num;
    int count;
    
    public Tangerine(int num, int count) {
        this.num = num;
        this.count = count;
    }
    
    @Override
    public int compareTo(Tangerine t) {
        return t.count - this.count;
    }
    
}

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        ArrayList<Tangerine> arr = new ArrayList<>();
        
        Arrays.sort(tangerine);
        arr.add(new Tangerine(tangerine[0],1));
        int idx = 0;
        for(int i =1;i<tangerine.length;i++) {
            if(arr.get(idx).num == tangerine[i]) {
                arr.get(idx).count++;
            } else {
                idx++;
                arr.add(new Tangerine(tangerine[i],1));
            }
        }
        
        Collections.sort(arr);
        idx = 0;
        int now = -1;
        while(true) {
            
            if(arr.get(idx).count !=0) {
                arr.get(idx).count--;
                k--;
            } else {
                answer++;
                idx++;
            }
            
            if(k == 0) break;

        }
        
        
        
        return answer;
    }
}