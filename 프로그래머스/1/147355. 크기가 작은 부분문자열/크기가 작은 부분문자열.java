class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int pLen = p.length();
        for(int i=0;i<t.length()-pLen+1;i++) {
            if(Long.parseLong(p) >= Long.parseLong(t.substring(i,pLen+i)))answer++;
        }
        
        
        return answer;
    }
}