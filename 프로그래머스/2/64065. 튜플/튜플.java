import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i =0; i<=100000;i++) arr.add(new ArrayList<>());
        
          int j = 1;
        int idx = -1;
        while(true) {
            if(j == s.length()) break;


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

        
        // for(int j =1; j<s.length()-1;j++) {
        //     if(s.charAt(j) == '{') idx++;
        //     else if(s.charAt(j) != '{' && s.charAt(j) != ',' && s.charAt(j) != '}') {
        //         arr.get(idx).add(s.charAt(j)-'0');
        //     } 
        // }
        
        // for(Integer li : arr.get(0)) {
        //     System.out.print(li.get(0)+" ");
        // }
        
        // for(int k =0; k<=100000;k++) {
        //     if(arr.get(k).size() == 0) break;
        //     for(Integer kk : arr.get(k)) {
        //     System.out.print(kk+" ");
        //     }
        // }
        //             System.out.println("ㅡㅡㅡㅡ");

        ArrayList<Integer> ans = new ArrayList<>();
        int count = 1;
       int index = 0;
        while(true) {
            if(arr.get(index).size() == count) {
               for(Integer in :arr.get(index)) {
                   ans.add(in);
                   // System.out.print(in+" / ");
               }
                count++;
                index = 0;
            } else
                index++;
            if(arr.get(index).size() == 0) break;
        }
                           // System.out.println();

        int pos = -1;
        ArrayList<Integer> real = new ArrayList<>();
        for(int k =0 ;k<ans.size();k++) {
            int num = ans.get(k);
            if(k == 0) real.add(num);
            else {
                boolean flag = false;
                for(int dd = 0; dd<real.size();dd++) {
                    if(real.get(dd) == num) {
                        flag = true;
                        break;}
                }
                if(!flag) real.add(num);
              
            }
        }
        
                int[] answer = new int[real.size()];

        
        for(int l = 0; l<real.size();l++)answer[l] = real.get(l);

        
        return answer;
    }
}