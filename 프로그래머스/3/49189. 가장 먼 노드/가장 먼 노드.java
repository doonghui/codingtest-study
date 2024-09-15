import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
         int answer = 0;
        ArrayList<ArrayList<Integer>> gragh = new ArrayList<>();

        for(int i=0;i<=n;i++) gragh.add(new ArrayList<>());

        // 양방향그래프
        for(int[] arr : edge) {
            int a = arr[0];
            int b = arr[1];
            gragh.get(a).add(b);
            gragh.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] visited = new boolean[n+1];
        dist[1] = 0;
        visited[1] = true;
        while(!q.isEmpty()) {
            int t = q.poll();
            for(Integer node :gragh.get(t)) {
                if(!visited[node] && dist[node] > dist[t]+1) {
                    dist[node] = dist[t] +1;
                    visited[node] = true;
                    q.add(node);
                }

            }

        }


        Arrays.sort(dist);
        int idx = 0;
        int max = -1;
        for(int k = n;k>=0;k--) {
            if(dist[k] != Integer.MAX_VALUE)
             {
                idx = k;
                max = dist[k];
                break;
            }
        }

        for(int k = idx;k>=0;k--) {
            if(dist[k] == max) answer++;
            else {

                break;
            }
        }

        return answer;
    }
}