import java.io.*;
import java.util.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            if(num == 0) {
                if (pQ.size() == 0) bw.write("0\n");
                else
                    bw.write(pQ.poll()+"\n");
            } else pQ.add(num);
        }



        br.close();
        bw.flush();
        br.close();
    }


}