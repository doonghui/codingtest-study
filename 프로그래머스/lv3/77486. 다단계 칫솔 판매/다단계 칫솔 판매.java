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
                String fromPerson = seller[j];
                String toPerson = people.get(fromPerson);
                int profit = amount[j]*100;
                while(true) {
                    if(profit == 0) break;
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