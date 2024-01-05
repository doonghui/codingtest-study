import java.util.*;

class Disk{
    int start;
    int time;

    public Disk(int start, int time) {
        this.start = start;
        this.time = time;
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
            while (!disk.isEmpty()) {           // len 안에 작업가능한 요청들 확인
                if (disk.peek().start > len) break;
                arr.add(disk.poll());
            }

            if (arr.isEmpty()) len++;           // 작업가능한게 하나도 없을 시
            else {
                Disk d = arr.poll();

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
