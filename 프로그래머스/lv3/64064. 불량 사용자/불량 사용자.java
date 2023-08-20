import java.util.ArrayList;


class Solution {
    
    static int ans;
    static ArrayList<ArrayList<Integer>> visited;

    
    public int solution(String[] user_id, String[] banned_id) {
        int[] check = new int[user_id.length];
        visited = new ArrayList<>();

        
 
        dfs(check,user_id,banned_id,0);
       
        
        
        
        return ans;
    }
    
 static void dfs(int check[], String[] user_id, String[] banned_id, int cnt) {
        if (cnt == banned_id.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                    list.add(check[i]);
            }
            boolean flag = false;
            if(visited.size() == 0) {
                visited.add(list);
                ans++;
            } else {
                for(int j =0; j<visited.size();j++) {
                    int tmp = 0;
                    for(int k =0; k<user_id.length;k++) {
                        if(visited.get(j).get(k) == list.get(k)) {
                            tmp++;
                        }
                        
                    }
                    if(tmp == list.size()) {
                            flag = true;
                            break;
                        }
                }
                  if(!flag) {
                visited.add(list);
                ans++;
            }
            }
          
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            int count = 0;
            if (check[i] == 1) continue;
            if (user_id[i].length() != banned_id[cnt].length()) continue;

            for (int j = 0; j < user_id[i].length(); j++) {
                if (user_id[i].charAt(j) == banned_id[cnt].charAt(j) || banned_id[cnt].charAt(j) == '*') count++;
            }

            if (count == banned_id[cnt].length()) {
                check[i] = 1;
                dfs(check, user_id, banned_id, cnt + 1);
                check[i] = 0;
            }

        }


    }

    
    
}