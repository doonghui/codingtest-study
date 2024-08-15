import java.util.*;


class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int num = -1;
        for(int i =0;i<nums.length;i++) {
            if(num != nums[i]) {
                answer += 1;
                num = nums[i];
            }
            
            if(answer >= nums.length/2) break;            // 최대 N/2
        }
        
        
        return answer;
    }
}