import java.util.*;
class Solution {
   
        static Map<String,String> people;
        static Map<String,Integer> money;
        static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];

            people = new HashMap<>();
            money = new HashMap<>();

            for(int i =0; i<enroll.length;i++) {
                people.put(enroll[i],referral[i]);
                money.put(enroll[i],0);
            }


            for(int j =0; j<seller.length;j++) {
                String fromPerson = seller[j];              // 판매원
                String toPerson = people.get(fromPerson);   // 추천인
                int profit = amount[j]*100;
                while(true) {
                    
                    if(profit == 0) break;                  // 11,12,13 시간초과이유 : 줘야하는 이익이 0원이라면 계산해도 어차피 또 0원이 나오니 이때는 break
                    if(toPerson.equals("-")) {
                        calculate(fromPerson,profit);
                        break;
                    }
                    String tmp = toPerson;
                    profit = calculate(fromPerson,profit);
                    toPerson = people.get(toPerson);
                    fromPerson = tmp;
                }



            }

            for(int x = 0; x<enroll.length;x++) {
                answer[x] = money.get(enroll[x]);
            }


            return answer;
        }

        static int calculate(String fromPerson,int profit) {
            money.put(fromPerson,money.get(fromPerson)+profit - (profit/10));

            return profit/10;



        }
}
