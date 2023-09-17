import java.util.*;


class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ed){
        return this.cost - ed.cost;
    }
}

class Solution {
    
    static ArrayList<ArrayList<Edge>> gragh;

    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        
        gragh = new ArrayList<>();
        
        for(int k =0; k<=n;k++) {
            gragh.add(new ArrayList<Edge>());
        }
        
        for(int i =0; i<fares.length;i++) {
                int v1 = fares[i][0];
                int v2 = fares[i][1];
                int cost = fares[i][2];
                
                gragh.get(v1).add(new Edge(v2,cost));
                gragh.get(v2).add(new Edge(v1,cost));
        }
        int[] dis = new int[n+1];
        int[] disA = new int[n+1];
        int[] disB = new int[n+1];
        
        Arrays.fill(dis,Integer.MAX_VALUE);
        Arrays.fill(disA,Integer.MAX_VALUE);
        Arrays.fill(disB,Integer.MAX_VALUE);
        
        dis = sol(s,dis);
        disA = sol(a,disA);
        disB = sol(b,disB);
        
        answer = dis[a] + dis[b];           // 따로 택시탔을 때
        
        for(int l = 1 ; l<=n;l++) {
            answer = Math.min(answer,dis[l]+disA[l]+disB[l]);           // 합승했을 때
        }
        
        return answer;
    }
    
    
    public int[] sol(int start, int[] dis) {
        
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        
        dis[start] = 0;
        pQ.add(new Edge(start,0));
        
        
        while(!pQ.isEmpty()) {
            Edge now = pQ.poll();
            
            if(now.cost >dis[now.vex]) continue;            // 이미 그 정점에 최솟값이 있는데 pQ에 더 큰 cost 가 있을 때 더 볼 필요 x
            
            for(Edge nx : gragh.get(now.vex )) {
                if(dis[nx.vex] > now.cost + nx.cost) {
                    dis[nx.vex] = now.cost + nx.cost;
                    pQ.add(new Edge(nx.vex,dis[nx.vex]));
                    
                }
                
            }
            
        }
        
        
        
        return dis;
    }
    
    
}
