import java.util.*;

class Solution {

    public  int solution(String[][] clothes) {
          int answer = 0;

        HashMap<String,Integer> map = new HashMap<>();

        ArrayList<String> arr = new ArrayList<>();

        for(int i =0;i<clothes.length;i++) {
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1],1);
                arr.add(clothes[i][1]);
            } else {
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
        }


        int value = 1;

        for(int j =0;j<arr.size();j++) {
            value *= (map.get(arr.get(j))+1);
        }

        answer = value -1;




        return answer;


    }

}