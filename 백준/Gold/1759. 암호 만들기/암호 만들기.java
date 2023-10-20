
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;



class Main {

    static int l,c;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> ans;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), "  ");
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        String ex = br.readLine();
        int num = 0;
        for (int i = 0; i < ex.length();i++) {
            if(ex.charAt(i) != ' ') {
                arr[num++] = ex.charAt(i);
            }

        }
        ans = new ArrayList<>();
        char[] str = new char[l];
        visited = new boolean[c];
        Arrays.sort(arr);
        dfs(0,0,str);

        br.close();
        bw.flush();
        bw.close();

    }

    static void dfs(int level,int x,char[] str) {
        if(level == l) {
            int cnt = 0;
            int cnt2 = 0;
            for(int i =0; i<l;i++) {
                if(str[i] == 'a' || str[i] == 'e'|| str[i] == 'i'|| str[i] == 'o'|| str[i] == 'u') cnt++;
                else
                    cnt2++;
            }

            if(cnt < 1 || cnt2 < 2) return;

            for(int j =0; j<l;j++) {
                if(j != 0 && (int)str[j] < (int)str[j-1]) return;
            }

            System.out.println(str);

            return;
        }

        for(int i =x; i<c;i++) {
            if(!visited[i]) {
                visited[i] = true;
                str[level] = arr[i];
                dfs(level+1,x+1,str);
                visited[i] = false;

            }
        }






    }

}