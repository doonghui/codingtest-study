import java.util.*;

class Solution
{
        public  int solution(String s) {
        int answer = 1;
        int len = s.length();
        for (int i = len; i >= 2; i--) {
            if(sol(s, i, len)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    static boolean sol(String s, int n, int len) {      // n개 뒤집었을 때 같은것 (n >1)
        for (int i = 0; i <= len - n; i++) {
            int up = 0;
            int down = n - 1;
            while (up <= down) {
                if (s.charAt(i + up) != s.charAt(i + down)) {
                    break;
                }
                up++;
                down--;
            }

            if(up > down) return true;
        }
        return false;

    }
    
}