import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static  int[] newWeak;

   
    
    public  int solution(int n, int[] weak, int[] dist) {


        boolean[] visited = new boolean[dist.length];
        ArrayList<Integer> visitArr = new ArrayList<>();

        newWeak = new int[weak.length*2];

        for(int j =0; j<weak.length;j++) {
            newWeak[j] = weak[j];
            newWeak[j + weak.length] = weak[j]+n;
        }


        for (int i = 1; i < weak.length; i++) {              // 취약지점 선택
            select(i, 0, dist, visited,visitArr);
        }
        
        if(answer == Integer.MAX_VALUE) answer =-1;

        return answer;
    }

    static void select(int weakIdx, int dept, int[] dist, boolean[] visited,ArrayList<Integer> visitArr) {
        if (dept == dist.length) {
            int ans = check(weakIdx, visitArr);
            if (ans != Integer.MAX_VALUE) {
                answer = Math.min(answer, ans);
                return;
            }


        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                visitArr.add(dist[i]);
                select(weakIdx, dept + 1, dist, visited, visitArr);
                visited[i] = false;
                visitArr.remove(visitArr.size()-1);

            }

        }

    }

    static int check(int weakIdx, ArrayList<Integer> visitArr) {
        int start = weakIdx;                    // 시작 인덱스
        int end = start+newWeak.length/2;       // 마지막 인덱스


        int people = 1;
        int distance = newWeak[start]+visitArr.get(0);

        for(int i=start; i<end; i++) {
            if(distance < newWeak[i]) {
                people++;
                if (people > visitArr.size()) return Integer.MAX_VALUE;
                distance = newWeak[i] + visitArr.get(people-1);
            }
        }
        return people;

    }
}












    
