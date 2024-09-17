import java.util.*;
class Solution {
  
    static int ans = 0;
    static boolean[] visited;

    public  int solution(String numbers) {

        char[] c = numbers.toCharArray();

        Set<Integer> set = new HashSet<>();
        visited = new boolean[c.length];
        for (int i = 1; i <= c.length; i++) {

            per(c, i, 0, "", set);

        }

        return ans;
    }

    static void per(char[] c, int len, int L, String str, Set<Integer> set) {
        if (L == len) {
            int num = Integer.parseInt(str);
            if (set.contains(num)) return;
            set.add(num);
            if(num == 0 || num == 1) return;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return;
            }

            ans++;
            return;
        }

        for (int k = 0; k < c.length; k++) {
            if (!visited[k]) {
                str += c[k];
                visited[k] = true;
                per(c, len, L + 1, str, set);
                visited[k] = false;
              str = str.substring(0, str.length()-1);
            }


        }


    }
    
}