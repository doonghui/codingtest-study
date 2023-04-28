class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum =0;
        for(int i =1;i <n/2+1;i++){
            for(int j =i;j<=(n/2)+1;j++){
                sum += j;
                if(sum > n)
                    break;
                if(sum == n){
                    answer++;
                    break;
                }

            }
            sum =0;
        }
    
                answer++;
        
        return answer;
    }
}