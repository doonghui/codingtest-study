class Solution {
    static int cntZero = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        while(!s.equals("1")){
             s =  change(s);
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = cntZero;
        
       
        
        
        
        
        
        return answer;
    }
    
    static String change(String x) {
        int k = 0;
        for(int i =0; i<x.length();i++){
            char c= x.charAt(i);
            if(c == '0')
                cntZero++;
            else{
                k += 1;
            }     
        }
        
        String str = "";
        while(k >= 1){
            int tmp = k %2;
            k = k / 2;
            str = tmp + str;
        }
        return str;
    }
    
}