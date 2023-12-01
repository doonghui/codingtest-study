import java.util.*;

class Solution {
    static boolean flag = false;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx =0;
        
        for(long number : numbers) {
        String binaryNumber = Long.toBinaryString(number);
            
        int nodNumber = 0;
        int height = 1;
        while(nodNumber < binaryNumber.length()) {
            nodNumber = (int)Math.pow(2,height) -1;
            height++;
        }
            
        int[] binary = new int[nodNumber];      // 이진수 배열로 저장
        int len = nodNumber-binaryNumber.length();
            
        for(int i = 0;i <len;i++) {
           binary[i] = 0;
        }

        for(int j = len;j <nodNumber;j++) {
           binary[j] = binaryNumber.charAt(j-len)-'0';
        }
            
           
        check(0,binary.length-1,binary);
        if(flag) {
            answer[idx] = 0;
            flag = false;
        } else {
            answer[idx] = 1;
        }
        idx++;
        }
            
        return answer;
    }
    
    
    static void check(int lt,int rt,int[] binary) {
        if(flag) return;
        if(binary.length == 1) {
            if(binary[0] == 0) flag = true;
        }
        if(lt == rt) return;
        int mid = (lt + rt) / 2;
        int left =(lt + mid-1) /2;
        int right =(mid+1 + rt) /2;
       
            if(binary[mid] ==0) {       // 부모 노드가 없는데 자식이 있으면 안됨!
                if(binary[left] == 1 || binary[right] == 1) {
                      flag = true;
                return; 
                }
             }
            
        check(lt,mid-1,binary);
        check(mid+1,rt,binary);
            
    }
}