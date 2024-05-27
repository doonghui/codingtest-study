import java.util.*;

class Solution {
  
    static int[] unf;
    static boolean[] visited;
    public  int solution(int n, int[][] computers) {
        int answer = 0;


        unf = new int[n+1];
        for(int j =0;j<=n;j++) unf[j] = j;
       visited = new boolean[n+1];
        for(int i =0;i<computers.length;i++) {
            solve(i,computers);
        }

        int tmp =0;
        
    for(int i =1;i<=n;i++) {

            if(unf[i] == i) answer++;
        }
        
        
        // for(Integer k : unf) {
        //     if(k == 0) continue;
        //     if(k!= tmp) {
        //         answer++;
        //         tmp = k;
        //     }
        // }

        return answer;
    }


     static void solve(int n,int[][] computers) {

            for(int i =0;i<computers.length;i++) {
                // if(num == i+1) continue;            // 자기자신일 때

                if(n != i && computers[n][i] == 1) {
                    union(n+1,i+1);

                }
            }


    }

     static int find(int v) {
        if(unf[v] == v) return v;
        else
            return unf[v] = find(unf[v]);
    }

     static void union(int a,int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa < fb) unf[fb] = fa;
        else
            unf[fa] = fb;
    }

    
}