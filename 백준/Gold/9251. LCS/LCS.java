import java.util.Scanner;

public class Main {
    static String s1, s2;


    public static void main(String[] args ) throws Exception {



            Scanner scanner = new Scanner(System.in);
            String s1, s2;
            s1 = scanner.nextLine();
            s2 = scanner.nextLine();
            int table[][] = new int[1002][1002];

            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    } else {
                        table[i][j] = Integer.max(table[i-1][j], table[i][j-1]);
                    }
                }
            }
            System.out.println(table[s1.length()][s2.length()]);
            





    }




}