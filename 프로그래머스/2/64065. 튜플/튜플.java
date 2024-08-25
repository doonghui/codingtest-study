import java.util.*;

class Solution {
    public int[] solution(String s) {
       
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i =0;i<500;i++) arr.add(new ArrayList<>());         // return 하는 배열의 길이가 1 이상 500 이하인 경우
        
                String [] strs = s.replaceAll("[{}]", "").trim().split(",");

        Arrays.sort(strs, (a,b)->(a.length()-b.length()));
        
        int j = 1;
        int idx = -1;
        while(j < s.length()) {                                     // 배열로 바꾸기
            if(s.charAt(j) != '{' && s.charAt(j) != ',' && s.charAt(j) != '}'){
                idx++;
                int start = j;
                int end = j;
                while(true) {
                    end++;
                    if(s.charAt(end) == ',') {
                        arr.get(idx).add(Integer.parseInt(s.substring(start,end)));
                        start = end+1;
                    } else if(s.charAt(end) == '}') {
                        arr.get(idx).add(Integer.parseInt(s.substring(start,end)));
                        break;
                    }
                }
                j = end;
            }

            j++;
        }



        
        
        Collections.sort(arr, (a,b)->(a.size()-b.size()));          // size 오름차순 정렬
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(ArrayList<Integer> ar : arr) {
            if(ar.size() == 0) continue;
            for(Integer in : ar) {
                if(set.add(in)) {
                    ans.add(in);
                    break;
                }
            }
        }
         
        int[] answer = new int[ans.size()];
        for(int l =0;l<ans.size();l++) {
            answer[l] = ans.get(l);
        }

        return answer;
    }
}