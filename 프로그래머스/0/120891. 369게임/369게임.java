class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String s = order +"";
        
        for(int i = 0;i<s.length();i++) {
            char o = s.charAt(i);
            if(o == '3' || o == '6' || o == '9') answer++;
        }
        
        return answer;
    }
}