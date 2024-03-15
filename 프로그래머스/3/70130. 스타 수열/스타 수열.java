import java.util.*;

class Point implements Comparable<Point> {
    int key;
    int value;
    
    public Point(int key, int value) {
        this.key =key;
        this.value = value;
    }
    @Override
    public int compareTo(Point o) {
        return o.value - this.value;        
    }
}


// 42.9 -> 46.4
class Solution {
    public int solution(int[] a) {
        int answer = -1;
        
        ArrayList<Point> arr = new ArrayList<>();
        for(int i =0;i<a.length;i++) arr.add(new Point(i,0));
        
        if(a.length <2) answer = 0;
        else {
         for(int i = 0;i<a.length;i++) {
             arr.get(a[i]).value += 1;
         }
        
        Collections.sort(arr);

            
        for(Point p : arr) {
            if(p.value <= answer) break;
            int cnt = 0;
            for(int j =0;j<a.length-1;j++) {
                if(a[j] != a[j+1] && (a[j] == p.key || a[j+1] == p.key)) {
                    cnt++;
                    j++;
                }
 
            }
            
            answer = Math.max(answer,cnt);
        }
        }
        
        return answer *= 2;
    }
}