import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int n, m;
    static char[][] arr;

    static int Sol() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '-') {
                    if(j+1 > m) continue;
                    if (arr[i][j + 1] != '-')
                        cnt++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == '|') {
                    if(j+1 > n) continue;
                    if (arr[j + 1][i] != '|')
                        cnt++;
                }
            }
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] =tmp.charAt(j);
            }

        }


            bw.write(Sol()+"");
            br.close();
            bw.flush();
            bw.close();
        }
    }



