import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class URL implements Comparable<URL>{
    int idx;
    String urlName;
    double wordCnt = 0;
    ArrayList<String> outerUrl = new ArrayList<>();
    double outerScore = 0;
    double totalScore = -1;

    public URL(int idx) {
    this.idx = idx;
    }

    @Override
    public int compareTo(URL o) {
        if(o.totalScore == this.totalScore) {
            return this.idx - o.idx;
        }
        return (int) (o.totalScore - this.totalScore);
    }
}

class Solution {
    static ArrayList<URL> url;

    // 1. 웹 페이지 정보 가져오기
    // 2. body 안에 맞는 문자 찾아서 개수세기
    // 3. 외부 url 찾아서 정보 arraylist에 넣기
    public static int solution(String word, String[] pages) {


        int idx = 0;
        url = new ArrayList<>();
        for (String page : pages) {
            word = word.toLowerCase();
            page = page.toLowerCase();
            url.add(new URL(idx));
            idx++;
            check(word, page);
        }


        for(URL u : url) {
            for(String str : u.outerUrl) {
                for(URL ur : url) {
                    if(ur.urlName.equals(str)) {
                        ur.totalScore += u.outerScore;
                        break;
                    }
                }

            }
        }


     double max = 0;
        int answer = 0;
        for(URL u: url){
            if(u.totalScore == max){
                if(u.idx < answer)
                    answer = u.idx;
            }
            else if(u.totalScore > max) {
                answer = u.idx;
                max = u.totalScore;
            }
        }

        return answer;

    }

    static void check(String word, String page) {
        int left = 0;
        int right = 0;
        int mid = 0;
        while(mid <= left) {
            left = page.indexOf("<meta", left+1);
            right = page.indexOf(">", left);
            mid = page.lastIndexOf("https://", right);
        }
        right = page.indexOf("\"", mid);
        String subUrl = page.substring(mid, right);
        url.get(url.size()-1).urlName = subUrl;



        int bodyUrlIdx = page.indexOf("<body>");
        int bodyUrlLastIdx = page.indexOf("</body>",bodyUrlIdx);

        String bodyPage = page.substring(bodyUrlIdx+6, bodyUrlLastIdx);

        checkWord(word,bodyPage);


    }
 
    static void checkWord(String word,String bodyPage) {
        
        double count = 0;
        String subBodyPage = bodyPage;
        while(subBodyPage.contains(word)) {
            int wordIdx = subBodyPage.indexOf(word);
            int wordLastIdx = wordIdx + word.length()-1;
            if(!Character.isLetter(subBodyPage.charAt(wordIdx-1))&&!Character.isLetter(subBodyPage.charAt(wordLastIdx+1))) {
                count++;
            }
            subBodyPage = subBodyPage.substring(wordLastIdx);
        }
        

        while(bodyPage.contains("<a href=\"")) {
            int linkUrlIdx = bodyPage.indexOf("<a href=\"");
            int linkUrlLastIdx = bodyPage.indexOf("\">",linkUrlIdx);

            String outerUrl = bodyPage.substring(linkUrlIdx+9,linkUrlLastIdx);

            url.get(url.size()-1).outerUrl.add(outerUrl);

            bodyPage = bodyPage.substring(linkUrlLastIdx);
        }


        url.get(url.size()-1).wordCnt = count;
        url.get(url.size()-1).totalScore = count;
        url.get(url.size()-1).outerScore =  url.get(url.size()-1).wordCnt /  url.get(url.size()-1).outerUrl.size();
    }

}
