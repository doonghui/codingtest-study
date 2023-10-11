import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int winner = 0;
        String ans = "";
        if(n % 2 != 1) winner = 1;

        if(winner == 0) ans = "SK";
        else
            ans = "CY";


        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();


    }


}
