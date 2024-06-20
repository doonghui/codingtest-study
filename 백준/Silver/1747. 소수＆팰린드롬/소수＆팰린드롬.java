
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10000001];
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= arr.length - 1; i++) {
            if (i >= n && !arr[i])
                list.add(i);

            for (int j = i + i; j <= 10000000; j += i) {
                arr[j] = true;
            }
        }

        for (int i : list) {
            String num = String.valueOf(i);
            String reversed = new StringBuilder(num).reverse().toString();

            if (num.equals(reversed)) {
                System.out.println(num);
                return;
            }
        }
    }
}