import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static String n;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = br.readLine();
        String num = "1";
        int idx = 0;
        while (true) {
            for (int i = 0; i < num.length(); i++) {
                if (n.charAt(idx) == num.charAt(i)) {
                    idx++;
                }
                if (idx == n.length()) break;
            }

            if (idx == n.length()) break;
            int tmp = Integer.parseInt(num);
            tmp++;
            num = tmp + "";
        }


        bw.write(num + "");


        br.close();
        bw.flush();
        bw.close();

    }


}