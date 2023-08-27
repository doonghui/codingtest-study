import java.util.*;




class Solution {
    static ArrayList<ArrayList<Integer>> nodes;
    
    public int solution(int n, int[][] edge) {
       int answer = 0;
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        nodes = new ArrayList<>();
        for(int k =0; k<=n;k++) nodes.add(new ArrayList<Integer>());
        for(int i=0; i<edge.length;i++) {
            nodes.get(edge[i][0]).add(edge[i][1]);
            nodes.get(edge[i][1]).add(edge[i][0]);
        }

        bfs(arr,visited);

        int max = Integer.MIN_VALUE;
        for(int j =2; j<=n;j++) {
           max = Math.max(max,arr[j]);
        }
        
        for(int t =2; t<=n;t++) {
            if(max == arr[t]) answer++;
        }



        return answer;
    }
    
    
    
    static void bfs(int[] arr,boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            Integer cv = q.poll();
            for(Integer nv : nodes.get(cv)) {
                if(!visited[nv]) {
                    visited[nv] = true;
                    q.add(nv);
                    arr[nv] = arr[cv] + 1;
                }

            }
        }
    }
}
