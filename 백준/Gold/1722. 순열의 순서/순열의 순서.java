
import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static boolean[] check;
    static BufferedWriter bw;


    public static void main(String[] args) throws Exception {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        int selection = Integer.parseInt(st.nextToken());

        if (selection == 1) {
            long idx = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (check[j]) continue;

                    if (idx - fac(n - i - 1) > 0) {
                        idx -= fac(n - i - 1);
                    } else {
                        check[j] = true;
                        sb.append(j).append(" ");
                        break;
                    }

                }
            }
            bw.write(sb.toString() + " ");
        } else {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));

            }

            long count = 0;
            for (int i = 0; i < n; i++) {
                int number = arr.get(i);
                for (int j = 1; j < number; j++) {
                    if (check[j]) continue;

                    count += fac(n-i-1);
                }
                check[number] = true;
            }
            count +=1L;
            bw.write(count+"");
        }


        br.close();
//        bw.write(ans + "");
        bw.flush();
        bw.close();
    }


    static long fac(int x) {
        long num = 1;

        for (int i = x; i >= 1; i--) num *= i;

        return num;
    }


}
