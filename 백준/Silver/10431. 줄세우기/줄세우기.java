import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (list.size() == 0) list.add(num);
                else {
                    boolean flag = false;
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k) > num) {
                            arr[a] += (j - k);
                            list.add(k, num);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) list.add(num);
                }


            }


        }

        for (int l = 1; l <= n; l++) {
            bw.write(l + " " + arr[l] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();


    }


}
