class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer;
        if(n > s){
             answer = new int[]{-1};
            return answer;
        }
        answer = new int[n];
        if(s % n == 0) {
            for(int i =0; i<n;i++) {
                answer[i] = s/n;
            }
        } else{
            int rem = n - (s%n);
            for(int j =0; j<rem;j++) answer[j] = s/n;
            
            for(int k=rem;k<n;k++) answer[k] = s/n +1;
            
        }
                 
        
        
        return answer;
    }
    

}