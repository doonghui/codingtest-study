import java.util.*;

// 5, 9~ 17 빼고 나머지 시간초과.. 어케 줄일까
class Solution {
    public String[] solution(String[] s) {
           String[] answer = new String[s.length];
        ArrayList<String> arr = new ArrayList<>();

        // s에서 110을 다 제외해준다.
        // 남은 s 중 뒤에서부터 확인해보고 0이 나오는 순간 그 뒤에 110 을 다 붙여준다.
        // 만약 끝까지 했을 때 0이 없으면 맨 앞에 110을 다 붙여준다.
        for (String str : s) {
            if (str.length() <= 3) {
                arr.add(str);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sbA = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    int len = sb.length();
                    if (len >= 2 && sb.charAt(len - 2) == '1' && sb.charAt(len - 1) == '1') {
                        sb.delete(len - 2, len);
                        sbA.append("110");
                    } else
                        sb.append(str.charAt(i));
                } else {
                    sb.append(str.charAt(i));
                }

            }


            boolean flag = false;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == '0') {
                    flag = true;
                    sb.insert(i + 1, sbA.toString());
                    break;
                }
            }

            if (!flag) {
                sb.insert(0, sbA.toString());
            }

            arr.add(sb.toString());
        }

        for (int i = 0; i < s.length; i++) {
            answer[i] = arr.get(i);
        }


        return answer;
    }

    

}
