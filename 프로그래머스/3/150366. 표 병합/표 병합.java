import java.util.*;


class Cell {
    String value;

}

class Solution {

    static Cell[][] map;
    static ArrayList<String> ans;

    public static String[] solution(String[] commands) {
        map = new Cell[51][51];

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                map[i][j] = new Cell();
            }
        }

        ans = new ArrayList<>();

        for (String command : commands) {
            String[] arr = command.split(" ");
            if (arr[0].equals("UPDATE")) {
                update(arr);
            } else if (arr[0].equals("MERGE")) {
                merge(arr);
            } else if (arr[0].equals("UNMERGE")) {
                unmerge(arr);
            } else if (arr[0].equals("PRINT")) {
                print(arr);
            }

        }
        String[] answer = new String[ans.size()];

        for (int k = 0; k < ans.size(); k++) {
            answer[k] = ans.get(k);
        }

        return answer;
    }


    static void update(String[] arr) {

        if (arr.length == 4) {
            int r = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            map[r][c].value = arr[3];
        } else if (arr.length == 3) {
            String before = arr[1];
            String after = arr[2];
            for (int i = 0; i <= 50; i++) {
                for (int j = 0; j <= 50; j++) {
                    if (map[i][j].value != null && map[i][j].value.equals(before)) map[i][j].value = after;
                }
            }
        }
    }

    static void merge(String[] arr) {
        int r1 = Integer.parseInt(arr[1]);
        int c1 = Integer.parseInt(arr[2]);
        int r2 = Integer.parseInt(arr[3]);
        int c2 = Integer.parseInt(arr[4]);


        if (map[r1][c1] == map[r2][c2]) return;      // 같은 셀일때

        if (map[r1][c1].value != null) {
            replacement(r2, c2, r1, c1);
        } else if (map[r2][c2].value != null) {
            replacement(r1, c1, r2, c2);
        } else {
            replacement(r2, c2, r1, c1);
        }


    }

    static void unmerge(String[] arr) {
        int r = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);

        Cell cell = map[r][c];

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                if (map[i][j] == cell) map[i][j] = new Cell();
            }
        }
        if (cell.value != null) {
            map[r][c].value = cell.value;
        }

    }

    static void print(String[] arr) {
        int r = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        if (map[r][c].value == null) ans.add("EMPTY");
        else
            ans.add(map[r][c].value);
    }

    static void replacement(int r1, int c1, int r2, int c2) {

        Cell cell = map[r1][c1];

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                if (map[i][j] == cell) map[i][j] = map[r2][c2];
            }
        }
    }
    }