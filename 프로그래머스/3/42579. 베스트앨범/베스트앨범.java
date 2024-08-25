import java.util.*;
class Solution {
    
    
        // 재생수 높은 순으로 장르 나오게 함 
        // 나온 장르가 1개 : 그냥 넣기
        // 2개 이상 : 클래스 만들어서 재생수 높은거 .. 같으면 고유번호 낮은거 넣기 -> count 로 2개 넣으면 다음 장르로!
    public int[] solution(String[] genres, int[] plays) {
        
    
        // 각 장르당 총 재생수 먼저 구하기
        HashMap<String,Integer> map = new HashMap<>();


        for(int i =0;i<genres.length;i++) {
            String genre = genres[i];
            int play = plays[i];

            map.put(genre,map.getOrDefault(genre,0) + play);
        }

        ArrayList<Genre> gen = new ArrayList<>();
        for(String key : map.keySet()) {
            gen.add(new Genre(key,map.get(key)));
        }

        Collections.sort(gen);

        ArrayList<Integer> ans = new ArrayList<>();

        for(Genre ge : gen) {
            PriorityQueue<Play> pq = new PriorityQueue<>();

            for(int j =0;j<genres.length;j++) {
                if(genres[j].equals(ge.g) ) {
                    pq.add(new Play(j,plays[j]));
                }
            }

            int count = 0;

            while(!pq.isEmpty()) {
                if(count == 2) break;
                int idx = pq.poll().index;
                // System.out.println(idx);
                ans.add(idx);
                count++;
            }

        }


        int[] answer = new int[ans.size()];

        for(int k =0;k< ans.size();k++) {
            answer[k] = ans.get(k);
        }





        
        return answer;
    }


}


class Genre implements Comparable<Genre> {
    String g;
    int num;

    public Genre(String g, int num) {
        this.g = g;
        this.num = num;
    }

    @Override
    public int compareTo(Genre ge) {
        return ge.num - this.num;
    }
}

class Play implements Comparable<Play> {
    int index;
    int play;

    public Play(int index, int play) {
        this.index = index;
        this.play = play;
    }

    @Override
    public int compareTo(Play pl) {
        if(pl.play == this.play) return this.index - pl.index;
        return pl.play - this.play;
    }
}





