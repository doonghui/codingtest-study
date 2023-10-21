
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Word implements Comparable<Word> {
    String word;
    int cnt;

    public Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Word wo) {
        if (this.cnt == wo.cnt) {
            if (wo.word.length() == this.word.length()) {
                    for(int j =0; j<this.word.length();j++) {
                        if(this.word.charAt(j) != wo.word.charAt(j)) return this.word.charAt(j) - wo.word.charAt(j);
                    }
            } else
                return wo.word.length() - this.word.length();
        }
        return wo.cnt - this.cnt;
    }
}


class Main {

    static int n, m;
    static ArrayList<Word> words;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        words = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() >= m) {
                map.put(str, map.getOrDefault(str, 0) + 1);            // 키가 있으면 +1, 아니면 1
            }
        }

        for (String i : map.keySet()) {
            words.add(new Word(i, map.get(i)));
        }


        Collections.sort(words);

        for (Word w : words) {
            bw.write(w.word + "\n");
        }


        br.close();
        bw.flush();
        bw.close();

    }


}