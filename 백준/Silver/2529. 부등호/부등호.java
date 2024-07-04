import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int k;
    static char[] operators;
    static boolean[] visited = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        operators = br.readLine().replace(" ", "").toCharArray();

        solve("", 0);

        results.sort(String::compareTo); 

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0)); 
    }

 
    static void solve(String num, int index) {
        if (index == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue; 

            if (index == 0 || check(num.charAt(index - 1) - '0', i, operators[index - 1])) {
                visited[i] = true;
                solve(num + i, index + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(int a, int b, char operator) {
        if (operator == '<') return a < b;
        else return a > b;
    }
}