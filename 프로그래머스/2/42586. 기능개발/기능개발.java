import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        for(int i =0;i<progresses.length;i++) {
            int a = (100 - progresses[i]) / speeds[i];
            int b = (100 - progresses[i]) % speeds[i];
            if(b == 0) arr[i] = a;
            else
                arr[i] = a+1;
        }
        int now = arr[0];
        int count = 1;
        System.out.println(Arrays.toString(arr)+" ");
        ArrayList<Integer> ans = new ArrayList<>();
        for(int j =1; j<arr.length;j++) {
            if(now < arr[j]) {
                ans.add(count);
                now = arr[j];
                count = 1;
            }
            else
                count++;
        }
        
        ans.add(count);
        
        
    int[] answer =  new int[ans.size()];
        int idx =0;
        for(int in : ans) {
            answer[idx] = in;
            idx++;
        }
        
        return answer;
    }
}