import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gcd = gcd(x, y);
 
            System.out.println(x + y - gcd);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
 
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}