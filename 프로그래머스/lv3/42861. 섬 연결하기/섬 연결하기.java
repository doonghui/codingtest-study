import java.util.*;
class Edge  implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
    public Edge(int v1,int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
    
    
}

class Solution {
    static int[] unf;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<Edge> gragh = new ArrayList<>();

        unf = new int[n];
        for(int i =0; i<n;i++) {
            unf[i] = i;
        } 
        
        for(int j=0;j<costs.length;j++) {
                gragh.add(new Edge(costs[j][0],costs[j][1],costs[j][2]));
                gragh.add(new Edge(costs[j][1],costs[j][0],costs[j][2]));
        }
        
        Collections.sort(gragh);
      
        
        answer = sol(gragh,0);
        
        
        return answer;
    }
    
    static int Find(int v) {
        if(v == unf[v]) return v;
        return unf[v] = Find(unf[v]);
        
    }
     
    static void Union(int a,int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa > fb) unf[fb] = fa;
        else unf[fa] = fb;
    }
    
    
    static int sol(ArrayList<Edge> gragh,int sum) {
        
        for(Edge e : gragh) {
            int fa = Find(e.v1);
            int fb = Find(e.v2);
            if(fa != fb) {
                sum += e.cost;
                Union(e.v1,e.v2);
            }
            
        }
        
            return sum;

        
    }
    

    
}