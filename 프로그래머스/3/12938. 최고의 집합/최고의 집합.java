class Solution {

    // 19 /3 = 6 .. 1   [6,6,7]
    // 20 / 3 = 6 .. 2  [6,7,7]
    // 19 / 2 = 9 ... 1 [9,10] x
    
    // s / n 가 0 or 9 + s %n >= 1 or 9 초과일때 -1
    public int[] solution(int n, int s) {
    
        int value = s /n;
        int left = s % n;      // 더해줘야하는 수
        int[] answer = new int[n];
        if(value == 0) answer = new int[]{-1};
        else {
                   for(int i =0;i<n;i++) {
            answer[i] = value;    
        }
        
        for(int j = 0;j<left;j++) {
            answer[n-j-1] = answer[n-j-1] +1;
        }
        
        }
    

 
        
        return answer;
    }
    

}