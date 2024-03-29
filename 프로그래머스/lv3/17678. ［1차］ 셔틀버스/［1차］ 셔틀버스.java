import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(String time : timetable) {
            char a = time.charAt(0);
            char b = time.charAt(1);
            char c = time.charAt(3);
            char d = time.charAt(4);
            String s = "";
            if(a == '0') {
                s = ""+b+c+d;
            } else
                s = ""+a+b+c+d;
            
            arr.add(Integer.parseInt(s));
        }
        
        Collections.sort(arr);
        
        int clockInt = sol(n,t,m,arr);
        if(clockInt % 100 >= 60) {
            clockInt -= 40;
        }
        
        
        String clock = clockInt+"";
        StringBuilder sb = new StringBuilder(clock); 

        String answer = "";
        if(clockInt < 10) {
            sb.insert(0,"00:0");
        }
        else if(clockInt < 100) {
            sb.insert(0,"00:");
        }
        else if(clockInt < 1000) {
            sb.insert(0,"0");
            sb.insert(2,":");
        } else {
            sb.insert(2,":");
        }

        
      
        
        answer = sb.toString();
        return answer;
    }
    
    
    static int sol(int n , int t ,int m, ArrayList<Integer>arr) {
        ArrayList<ArrayList<Integer>> shuttle = new ArrayList<>();
        for(int k =0; k<=n;k++) {
            shuttle.add(new ArrayList<Integer>());
        }
        
        // 셔틀 운행
        int time = 900;         // 버스 운행시간
        int minute = 0;
        int idx = 0;
        int restTime = t;
        boolean flag = false;
        for(int i = 1; i<=n;i++) {      // 1~ n 번 까지 버스
            int num = 0;
            for(int j =idx;j<arr.size();j++) {
                if(arr.get(j) <= time) {
                    shuttle.get(i).add(arr.get(j));
                    num++;
                    idx++;
                }
                if(num >=m) break;
            }
            
            
            if((time%10) + t >= 60) {
                 minute = (time%10) + t + 40;
                time += minute;
                flag = true;
            } else {
                time += t;
                flag = false;
            }
      
        }
        
        
        // 마지막 버스에 다 탔으면 마지막 버스의 맨 끝에 탄 사람 시간 -1분
        // 마지막 버스에 다 못탔으면 마지막 버스 시간
        if(shuttle.get(n).size() == m) {
            return shuttle.get(n).get(shuttle.get(n).size()-1) -1;
        } else {
            if(flag) {
                return time - minute;
            }
            else
                return time-t;
        }
        
    }
}
