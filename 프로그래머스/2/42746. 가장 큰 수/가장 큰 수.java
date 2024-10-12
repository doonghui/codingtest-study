import java.util.*;




class Solution {
    public String solution(int[] numbers) {
      String answer = "";
        String[] s = new String[numbers.length];
        for(int i =0;i<numbers.length;i++) {
            s[i] = numbers[i]+"";
        }

        Arrays.sort(s,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;

                return s1.compareTo(s2);
            }
        });

        // System.out.println(Arrays.toString(s));
        for(int i =s.length-1;i>=0;i--) {
            answer += s[i];
        }

        if(answer.charAt(0) == '0') return "0";

        return answer;
    }
}
