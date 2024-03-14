import java.util.*;

// 42 -> 101010
class Solution {
    
    static boolean flag;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        
        for(long number : numbers) {
            String str = Long.toBinaryString(number); 
            
            int h = 1;      // 이진트리의 높이
            while(Math.pow(2,h)-1 < str.length()) {
               h++;
            }
            
            if(Math.pow(2,h)-1 != str.length()) {       // 포화이진트리 만들기
                while(Math.pow(2,h)-1 != str.length()) {
                    str = "0" + str;
                }
            }
            char[] binary = str.toCharArray(); 
            
            flag = false;
            int mid = binary.length /2;
            int lt = mid /2;
            int rt = mid + (binary.length - mid) /2;
            check(0,binary.length-1,binary);
            
            if(!flag) {
                answer[idx] = 1;
            } else
                answer[idx] = 0;
            
           idx++; 
        }
        
        
        
        
        return answer;
    }
    
    
    static void check(int lt,int rt,char[] binary) {
        if(flag) return;
        
//         if(binary.length == 1) {
//             if(binary[0] == 0) flag = true;
//         }
        
        if(lt == rt) return;
        int mid = (lt + rt) /2;
        int left = (mid-1 + lt) /2;
        int right = (mid+1 + rt) /2;
        
        
        if(binary[mid] == '0') {
            if(binary[left] == '1' || binary[right] == '1') {
                flag = true;
                return;
            }
        }
        
        check(lt,mid-1,binary);
        check(mid+1,rt,binary);
    }
}

