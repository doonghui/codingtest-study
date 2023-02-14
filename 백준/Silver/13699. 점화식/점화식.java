import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static long[] ch;

//    static long Sol(int n){
//      
//        return ch[n];
//
//    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        ch = new long[n+1];
        ch[0] = 1;
        for(int x = 1; x<=n;x++){
            for(int i =0; i<x;i++){
                ch[x] += ch[i] * ch[x-1-i];
            }

        }


        br.close();
        bw.write(ch[n]+"");
        bw.flush();
        bw.close();
    }
}