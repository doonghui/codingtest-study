import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt(); 
        int K = sc.nextInt(); 

        int [] ddeok = new int [D]; 
        ddeok[D-1] = K; 
        int A = 1;

        while(true){
            ddeok[0] = A;
            for(int i=A; i<K; i++){
                ddeok[1] = i;
                for(int j=2; j<D-1; j++){ 
                    ddeok[j] = ddeok[j-1] + ddeok[j-2];
                }
                if(ddeok[D-1] == ddeok[D-2]+ddeok[D-3]){
                    System.out.println(ddeok[0]);
                    System.out.println(ddeok[1]); 
                    return;
                }
            }
            A++; 
       }

    }
}