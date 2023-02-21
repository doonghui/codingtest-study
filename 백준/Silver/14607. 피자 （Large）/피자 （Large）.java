import java.io.*;

public class Main {


    static long n;

    static long Sol(long n) {

        if (n <= 1) return 0;
        if (n == 2) return 1;

        if (n % 2 == 0)
            return (n / 2) * (n / 2) + Sol(n / 2) * 2;
        else
            return (n / 2) * (n / 2 + 1) + Sol(n / 2) + Sol(n / 2 + 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());


        bw.write(Sol(n) + "");
        br.close();
        bw.flush();
        bw.close();
    }
}



