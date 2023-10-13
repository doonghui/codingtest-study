import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {


    static ArrayList<Integer> arr;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            Integer num = null;
            if(!command.equals("all") && !command.equals("empty")) num = Integer.parseInt(st.nextToken());
            if (command.equals("add")) {
                if (!arr.contains(num)) arr.add(num);

            } else if (command.equals("remove")) {
                if (arr.contains(num)) arr.remove(num);
            } else if (command.equals("check")) {
                if (arr.contains(num)) bw.write("1\n");
                else
                    bw.write("0\n");
            } else if (command.equals("toggle")) {
                if (arr.contains(num)) arr.remove(num);
                else
                    arr.add(num);

            } else if (command.equals("all")) {
                arr.clear();
                for (int j = 1; j <= 20; j++) arr.add(j);

            } else if (command.equals("empty")) {
                arr.clear();

            }

        }

        bw.flush();
        br.close();
        bw.close();

    }


}
