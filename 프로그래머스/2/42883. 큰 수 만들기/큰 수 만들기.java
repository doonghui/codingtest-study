import java.util.*;

class Solution {
    public String solution(String number, int k) {
         StringBuilder sb = new StringBuilder();
        int lenIdx = k + 1;
        int idx = -1;
        for (int i = 0; i < number.length() - k; i++) {
            idx++;
            int max = Integer.MIN_VALUE;
            for (int j = idx; j < lenIdx; j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    idx = j;
                }
            }

            lenIdx++;
            sb.append(max);

        }


        return sb.toString();
    }
}