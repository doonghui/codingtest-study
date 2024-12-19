class Solution {
    // 20분 남음
    public int solution(int[] diffs, int[] times, long limit) {
        // 15~18, 20, 21 시간 초과
        // 고치고 난 이후에는 16,18,21 시간초과

        
        int start = 1;
        int end =  100000;
        int answer = 0;
        while(start <= end) {
            int level = (start + end)/2;
            long minValue = 0;
            for(int i =0;i<diffs.length;i++) {
                if(diffs[i] <= level) {
                    minValue += times[i];
                } else {
                    int minus = diffs[i] - level;
                    minValue += (times[i] + times[i-1]) * minus + times[i];
                }
                // if(minValue > limit) break;
            }

            if(minValue <= limit) {
                answer = level;
                end = level-1;
            } else {
                start = level+1;
            }
        }
        
        return answer;
    }
    

}