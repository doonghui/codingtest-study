import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> arr;
    static int idx;
    public int solution(int[] cards) {
        int answer = -1;
        
        boolean[] check = new boolean[cards.length];
        arr = new ArrayList<>();
        idx = 0;
        for(int i =0;i<cards.length;i++) {
            if(!check[i]) {
                arr.add(new ArrayList<>());
                
                checked(check,cards,i);   
                idx++;
                }
            
            if(arr.get(0).size() == cards.length) {
                answer = 0;
                break;
            }
            }
        
        if(answer == -1) {
            ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0;i<arr.size();i++) {
            ans.add(arr.get(i).size());
        }
        
        Collections.sort(ans);
            // System.out.print(ans.get(ans.size()-1)*ans.get(ans.size()-2) );
        answer = ans.get(ans.size()-1) * ans.get(ans.size()-2); 
        }
  
        
        
        
        return answer;
    }
    
    static void checked(boolean[] check,int[] cards,int index) {
        
        while(!check[index]) {
          check[index] = true;
          arr.get(idx).add(index);
          index = cards[index] -1;    
        }
        
        
        
        
    }
}


