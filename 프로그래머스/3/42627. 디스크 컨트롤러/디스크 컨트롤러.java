import java.util.*;

class Disk implements Comparable<Disk> {
    int start;
    int time;
    int end;

    public Disk(int start, int time) {
        this.start = start;
        this.time = time;
        this.end = this.start + this.time;
    }

    public int compareTo(Disk di) {
        if(this.end == di.end) return this.time - di.time;
        return this.end - di.end;
    }

}


class Solution {
    
       // 1. 해당 시간에 작업할 수 있는 애들을 확인한다.
    // 2. 그 중에 소요시간이 가장 짧은 애가 먼저 나온다.

   public  int solution(int[][] jobs) {
        int answer = 0;


        PriorityQueue<Disk> disk = new PriorityQueue<>(new Comparator<Disk>() {
            @Override
            public int compare(Disk o1, Disk o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Disk> arr = new PriorityQueue<>(new Comparator<Disk>() {
            @Override
            public int compare(Disk o1, Disk o2) {
                return o1.time - o2.time;
            }
        });

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] job : jobs) {
            disk.add(new Disk(job[0], job[1]));
        }


        int len = 0;
        int cnt = 0;        // 완료된 작업
        while (cnt != jobs.length) {
            while (!disk.isEmpty()) {
                if (disk.peek().start > len) break;
                arr.add(disk.poll());
            }

            if (arr.isEmpty()) len++;
            else {
                Disk d = arr.poll();
                if (len == 0) ans.add(d.start + d.time);
                else
                    ans.add(len - d.start + d.time);

                len += d.time;
                cnt++;

            }


        }
        for (int time : ans) {
            answer += time;
        }

        answer /= ans.size();


        return answer;
    }
    

}