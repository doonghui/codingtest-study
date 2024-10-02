class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[]  dist = new int[n+1];
        
        for(int l : lost) {
            dist[l] = -1;
        }
        
        for(int r : reserve) {
            if(dist[r] == -1) dist[r] = 1;
            else
                dist[r] = 2;
        }
    
        for(int i =1;i<n+1;i++) {
            if(dist[i] == 0) dist[i] = 1;
        }
        
        for(int i =1;i<n+1;i++) {
        if(dist[i] == 2) {
            if(dist[i-1] == -1) {
                dist[i-1] = 1;
                dist[i] = 1;
            } else if(i+1 < n+1 && dist[i+1] == -1) {
                dist[i+1] = 1;
                dist[i] = 1;
            }
        }
        
        }
        
          for(int k =1;k<n+1;k++) {
            if(dist[k] != -1) answer++;
        }
        
        
        return answer;
    }
}