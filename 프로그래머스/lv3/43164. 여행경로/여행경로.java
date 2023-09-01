import java.util.*;

class Airplane implements Comparable<Airplane> {
    String fromTicket;
    String toTicket;

    public Airplane(String fromTicket, String toTicket) {
        this.fromTicket = fromTicket;
        this.toTicket = toTicket;
    }

    @Override
    public int compareTo(Airplane ai) {

        if (this.toTicket.charAt(0) == ai.toTicket.charAt(0)) {
            if (this.toTicket.charAt(1) == ai.toTicket.charAt(1)) {
                return (int) (this.toTicket.charAt(2)) - (int) (ai.toTicket.charAt(2));
            } else
                return (int) (this.toTicket.charAt(1)) - (int) (ai.toTicket.charAt(1));

        } else
            return (int) (this.toTicket.charAt(0)) - (int) (ai.toTicket.charAt(0));

    }
}

class Solution {
       static ArrayList<String> ans;
    static boolean[] visited;
    static boolean flag = false;
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        ans = new ArrayList<>();
        
        ArrayList<Airplane> airplane = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        for(int i=0;i<tickets.length;i++){
          airplane.add(new Airplane(tickets[i][0],tickets[i][1]));  
        } 
        
        Collections.sort(airplane);

     
                ans.add("ICN");

        dfs(tickets, airplane);
        
        for(int j=0;j<ans.size();j++)  answer[j] = ans.get(j);
        
        return answer;
    }
    
    
    
    
  static void dfs(String[][] tickets, ArrayList<Airplane> airplane) {

        if (ans.size() == tickets.length + 1) {        //  {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}}
            flag = true;
            return;
        }

        for (int i = 0; i < airplane.size(); i++) {
            if (!visited[i] && (airplane.get(i).fromTicket).equals(ans.get(ans.size() - 1))) {
                visited[i] = true;
                ans.add(airplane.get(i).toTicket);
                dfs(tickets,airplane);
                if(flag) return;
                visited[i] = false;
                ans.remove(ans.size() - 1);
            }

        }


    }
}