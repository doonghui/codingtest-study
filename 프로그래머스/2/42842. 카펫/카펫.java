class Solution {
    public int[] solution(int brown, int yellow) {
        int h = 3;
        int w = 0;
        int size = brown + yellow;
        
        while(true) {
            if(size % h == 0) {
                w = size / h;
                if((h-2) * (w-2) == yellow) {
                    break;
                }
                
            }
            
            
            h++;
        }
        
        int[] answer = new int[2];
        answer[0] = w;
        answer[1] = h;
        return answer;
    }
}
