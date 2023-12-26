import java.util.*;

class Time {
    long start;
    long end;

    public Time(long start,long end) {
        this.start = start;
        this.end = end;
    }

}


class Solution {
    
    static ArrayList<Time> times;
    
    static int max = Integer.MIN_VALUE;

    public  int solution(String[] lines) {
        int answer = 0;

        times = new ArrayList<>();

        for(String line : lines) {
            line = line.substring(11,line.length()-1);
            String[] str = line.split(" ");
            String[] time = str[0].split(":");
            double pressTime =  Double.parseDouble(str[1]) * 1000;

            long hour = Long.parseLong(time[0]) * 60 * 60 * 1000;
            long minute = Long.parseLong(time[1]) * 60 * 1000;
            double second = Double.parseDouble(time[2]) * 1000;

            long end = hour + minute + (long)second;
            long start = end - (long)pressTime +1;
            times.add(new Time(start,end));
        }

        check();
        return max+1;
    }




    static void check() {
        for(int i =0; i<times.size();i++) {
            int count =0;
            long startTime = times.get(i).start;
            long endTime = times.get(i).end + 999;
            for(int j = i+1;j<times.size();j++){
                if( endTime >=times.get(j).start) {
                    count++;
                }
            }

            max = Math.max(count,max);

        }



    }
}