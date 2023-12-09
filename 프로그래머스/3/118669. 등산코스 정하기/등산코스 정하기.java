import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Edge implements Comparable<Edge>{
    int vex;
    int w;

    public Edge(int vex, int w) {
        this.vex = vex;
        this.w = w;
    }
    public int compareTo(Edge edge) {
        return this.w - edge.w;
    }
}

class Solution {
    static ArrayList<ArrayList<Edge>> arr;
    static Edge intensity;
    static int[] dis;           // 해당 등산코스의 최소 intensity
    static boolean[] checkGates;
    static boolean[] checkSummits;


    public  int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        arr = new ArrayList<>();
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }



        checkGates = new boolean[n+1];
        for (Integer gate : gates) {
            checkGates[gate] = true;
        }

        checkSummits = new boolean[n+1];
        for (Integer summit : summits) {
            checkSummits[summit] = true;
        }



        for (int j = 0; j < paths.length; j++) {
            int v1 = paths[j][0];
            int v2 = paths[j][1];
            int w = paths[j][2];
            arr.get(v1).add(new Edge(v2, w));
            arr.get(v2).add(new Edge(v1, w));
        }

        // 출입구에서 ~ 봉우리까지만 가면 됨.
        // 다른 출입구를 방문하면 안됨.
        for (Integer gate : gates) {
                bfs(gate, summits);
        }
        Arrays.sort(summits);
        intensity = new Edge(summits[0], dis[summits[0]]);
        for(int j = 1; j<summits.length;j++) {
            if(dis[summits[j]] < intensity.w) {
                intensity.vex = summits[j];
                intensity.w = dis[summits[j]];
            }

        }

        answer[0] = intensity.vex;
        answer[1] = intensity.w;


        return answer;
    }

    static void bfs(int gate, int[] summits) {     // flag = 산봉우리 확인
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(gate, 0));
        dis[gate] = 0;
        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();

            if(checkSummits[now.vex]) continue;                 // 이미 산봉우리에 도달했을 때

            if (dis[now.vex] < now.w) continue;                 
            for (Edge next : arr.get(now.vex)) {
                if (checkGates[next.vex]) continue;            // 출입구로 또 방문할 경우


                int max = Math.max(dis[now.vex], next.w);
                if (dis[next.vex] > max) {
                    dis[next.vex] = max;
                    pQ.add(new Edge(next.vex, max));
                }

            }
        }



    }


}