class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer;
        if(n > s){
             answer = new int[]{-1};
            return answer;
        }
        answer = new int[n];
        int v;
        int k = n;
        for(int j =0; j<k;j++) {
            v = s / n;
            answer[j] = v;
            s = s -v;
            n--;
        
        }
                 
        
        
        return answer;
    }
    

}