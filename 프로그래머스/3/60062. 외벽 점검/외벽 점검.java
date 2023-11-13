import java.util.*;
class Solution {
    static boolean flag = false;
    static int answer = Integer.MAX_VALUE;
    static  int[] weak_append;

   
    public  int solution(int n, int[] weak, int[] dist) {

//         Arrays.sort(dist,Collections.reverseOrder());       // 내림차순 정렬

//        ArrayList<Integer> distance = new ArrayList<>();

        boolean[] visited = new boolean[dist.length];
        ArrayList<Integer> visitArr = new ArrayList<>();

        weak_append = new int[weak.length*2];
        int j=0;
        while (j<weak.length){
            weak_append[j] = weak[j];
            weak_append[j + weak.length] = weak[j++]+n;
        }


        for (int i = 0; i < weak.length; i++) {              // 취약지점 선택
            select(i, 0, dist, visited, weak, visitArr, n);
        }
        
        if(answer == Integer.MAX_VALUE) answer = -1;

        return answer;
    }

    static void select(int weakIdx, int dept, int[] dist, boolean[] visited, int[] weak, ArrayList<Integer> visitArr, int n) {
        if (dept == dist.length) {
            int ans = check(weakIdx, visitArr, weak, n);
            if (ans != Integer.MAX_VALUE) {

                answer = Math.min(answer, ans);
                return;
            }


        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                visitArr.add(dist[i]);
                select(weakIdx, dept + 1, dist, visited, weak, visitArr, n);
                visited[i] = false;
                visitArr.remove(visitArr.size()-1);

            }

        }

    }

    static int check(int weakIdx, ArrayList<Integer> visitArr, int[] weak, int n) {
        int start = weakIdx;
        int end = start+weak_append.length/2;


        int friend = 1;// permuted의 index
        int pos = weak_append[start]+visitArr.get(friend-1);// 첫 취약점의 위치+친구거리 에서 시작

        for(int i=start; i<end; i++) {
            if(pos < weak_append[i]) {// 점검 위치 벗어나면
                friend++; // 친구추가
                if (friend > visitArr.size()) return Integer.MAX_VALUE; // 친구 초과하면 실패한 방법
                pos = weak_append[i] + visitArr.get(friend-1);
            }
        }
        return friend;

    }


}












    