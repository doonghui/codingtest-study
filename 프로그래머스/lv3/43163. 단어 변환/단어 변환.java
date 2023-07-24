import java.util.*;

class Node {
    String word;
    int count;

    public Node(String word,int count) {
        this.word = word;
        this.count = count;

    }


}


class Solution {

    public int solution(String begin, String target, String[] words) {
         int answer = 0;
        boolean flag = false;
        int beginLen = begin.length();
        boolean[] visited = new boolean[words.length];      // 한번 방문한곳 다시 방문하지 않기 위해

        // words 안에 target 이 있는지 확인
        for (String str : words) {
            if (target.equals(str)) flag = true;
        }
        if (!flag) return answer;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin,0));

        while (!q.isEmpty()) {
            Node nod = q.poll();
            for (int i = 0; i < words.length; i++) {
                int tmp = 0;
                if (!visited[i]) {
                    for (int j = 0; j < beginLen; j++) {
                        if (words[i].charAt(j) == nod.word.charAt(j)) tmp++;
                    }
                    if (beginLen - tmp == 1) {
                        visited[i] = true;
                        if (words[i].equals(target)) return nod.count + 1;
                        q.offer(new Node(words[i],nod.count+1));
                    }
                }

            }
        }


        return answer;
    }
}
