class Solution {
    
    public String solution(String s) {
        String answer = "";
        
        
        char[] c = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        int idx =0;
        for(int i =0;i<c.length;i++) {
            if(c[i] == ' ') {
                sb.append(' ');
                idx =0;}
            else if(idx % 2 == 0) {sb.append(Character.toUpperCase(c[i]));
                                  idx++;
                                  }
            else
                {sb.append(Character.toLowerCase(c[i]));
                idx++;}
        
            
        }
        
        

        
        return sb.toString();
    }
}