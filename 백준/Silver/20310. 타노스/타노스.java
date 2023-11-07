import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    static String n;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = br.readLine();
        int zero = 0;
        int one = 0;
        char[] arr = n.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') zero++;
            else
                one++;
        }
        zero /= 2;
        one /= 2;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == '1') {
                arr[j] = '2';
                one--;
            }
            if (one == 0) break;
        }


        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] == '0') {
                arr[j] = '2';
                zero--;
            }
            if (zero == 0) break;
        }
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] != '2') bw.write(arr[k] + "");
        }


        br.close();
        bw.flush();
        bw.close();


    }


}