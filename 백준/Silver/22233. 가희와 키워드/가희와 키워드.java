import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, false);
        }
        int result = map.size();

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine(), ",");
            int count = st.countTokens();
            while (count-- > 0) {
                String memo = st.nextToken();

                if (map.containsKey(memo)) {
                    if (!map.get(memo)) {
                        map.put(memo, true);
                        result--;
                    }

                }


            }

            bw.write(result + "\n");


        }


        br.close();
        bw.flush();
        bw.close();
    }


}