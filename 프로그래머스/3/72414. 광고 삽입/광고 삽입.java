import java.util.*;



class Solution {
    
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int play = Integer.parseInt(play_time.substring(0,2)) * 3600+  Integer.parseInt(play_time.substring(3,5)) * 60 + Integer.parseInt(play_time.substring(6,8));
        
        int adv = Integer.parseInt(adv_time.substring(0,2)) * 3600+  Integer.parseInt(adv_time.substring(3,5)) * 60 + Integer.parseInt(adv_time.substring(6,8));
        
        
        int[] time = new int[play +1];
        for(String log : logs) {
            int startH = Integer.parseInt(log.substring(0,2)) * 3600;
            int startM = Integer.parseInt(log.substring(3,5)) * 60;
            int startS = Integer.parseInt(log.substring(6,8));
            int endH = Integer.parseInt(log.substring(9,11)) * 3600;
            int endM = Integer.parseInt(log.substring(12,14)) * 60;
            int endS = Integer.parseInt(log.substring(15,17));
            
            
            int start = startH+startM+startS;
            int end = endH+ endM+endS;
            
            // start초 ~ end초까지 재생시간동안의 인원수 +1 씩
            for(int s = start; s<end;s++) {
                time[s]++;
            }
        }
        
        long sum = 0;
        // 0초 ~ adv초 까지 재생시간동안의 인원수 전부 sum에
        for(int i = 0; i<adv;i++) { 
        sum += time[i];
        }
        
        long max = sum;
        int t = 0;
        for(int j = adv;j<=play;j++) {
            sum = sum + time[j] - time[j-adv];
            
            if(sum > max) {
                max = sum;
                t = j - adv +1;
            }
              
        }
        String answer = "";
        int h = (t / 3600);
        int m = (t / 60)%60;
        int s = t % 60;
        if(h < 10) answer += "0" + h+":";
        else
            answer += h+":";
        
        if(m < 10) answer += "0" + m+":";
        else
            answer+=m+":";
        
        if(s <10) answer += "0"+s;
        else
            answer+=s;
        
  
        return answer;
        
    }
    
    
    
}