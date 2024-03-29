import java.util.*;

class Point implements Comparable<Point>{
    int num;
    int plays;
    
    public Point(int num, int plays) {
        this.num = num;
        this.plays = plays;
    }
    
    public int compareTo(Point o) {
        return this.plays - o.plays;
    }
    
    
}



class Solution {
public static int[] solution(String[] genres, int[] plays) throws Exception {
        int[] answer = {};
    
        HashMap<String,Integer> sum = new HashMap();

        // 장르별 재생횟수 합계
        for(int i=0; i<plays.length;i++) {
            sum.put(genres[i],sum.getOrDefault(genres[i],0)+plays[i]);
        }


        // value기준 내림차순 정렬
        ArrayList<String> keySet = new ArrayList<>(sum.keySet());    
        keySet.sort((o1, o2) -> sum.get(o2).compareTo(sum.get(o1)));

        // 순서대로 들어가게 하기 위해 LinkedHashMap()
        HashMap<String,Integer> sortedSum = new LinkedHashMap();       
        for(int j =0;j<sum.size();j++) {
            sortedSum.put(keySet.get(j),sum.get(keySet.get(j)));
        }


        // 장르 내 많이 재생된 노래 저장
        ArrayList<Point> arr = new ArrayList<>(); 
        ArrayList<Integer> ans =new ArrayList<>();

        for(String key : sortedSum.keySet()) {
            for(int k =0; k<genres.length;k++) {
                if(key.equals(genres[k])) arr.add(new Point(k,plays[k]));
            }

            // 내림차순 정렬
            Collections.sort(arr,Collections.reverseOrder());

            ans.add(arr.get(0).num);
            if(arr.size() != 1)  ans.add(arr.get(1).num);

            arr = new ArrayList<>();
        }

        answer = new int[ans.size()];
        for(int m =0; m <ans.size();m++) answer[m] = ans.get(m);


        return answer;
    }
}