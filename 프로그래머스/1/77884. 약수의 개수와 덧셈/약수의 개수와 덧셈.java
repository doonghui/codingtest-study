class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i<= right;i++) {
            if(solve(i)) answer += i;
            else
                answer -= i;
        }
        
        return answer;
    }
    
    
    static boolean solve(int num) {
        
        int count =0;
        for(int j = 1;j<=num;j++) {
            if(num % j == 0) count++;
        }
        
        if(count %2 ==0) return true;
        return false;
        
    }
}