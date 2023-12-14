import java.io.*;
import java.util.*;


class Player implements Comparable<Player> {
    int level;
    String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public int compareTo(Player pl) {
        return this.name.compareTo(pl.name);
    }


}


class Main {


    static int p, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Player>> players = new ArrayList<>();
        for (int i = 0; i <= p; i++) {
            players.add(new ArrayList<>());
        }

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();


            solution(l, nick, players);


        }


        for (int j = 0; j < p; j++) {
            if (players.get(j).size() == 0) break;
            Collections.sort(players.get(j));
            if (players.get(j).size() == m) {
                bw.write("Started!\n");
            } else
                bw.write("Waiting!\n");

            for (Player player : players.get(j)) {
                bw.write(player.level + " " + player.name + "\n");
            }
        }


        br.close();
        bw.flush();
        br.close();
    }

    static void solution(int level, String nickname, ArrayList<ArrayList<Player>> players) {
        for (int j = 0; j < p; j++) {
            if (players.get(j).size() == m) continue;
            if (players.get(j).size() == 0) {
                players.get(j).add(new Player(level, nickname));
                return;

            } else if ((level >= players.get(j).get(0).level - 10 && level <= players.get(j).get(0).level + 10)) {
                players.get(j).add(new Player(level, nickname));
                return;


            }
        }


    }


}