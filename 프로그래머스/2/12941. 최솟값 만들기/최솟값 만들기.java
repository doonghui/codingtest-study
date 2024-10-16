import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        int reIdx = B.length -1;
        while(idx < A.length && reIdx >= 0) {
            answer += (A[idx] * B[reIdx]);
            idx++;   
            reIdx--;
        
        }
        

        return answer;
    }
}