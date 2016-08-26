package grandfinale;
import java.util.*;
public class Problem10B {
    
    public static void main (String[] args) {
        System.out.println("Enter the number of S elements");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt(); 
        int[] S = new int[N];
        int sumS = 0;
        
        System.out.println("Enter the Positive elements of the S");
        for(int i=0 ; i<N ; i++) {
            S[i] = input.nextInt(); //accept N elements into s array
            sumS += S[i]; //add all the values of S array into sumS
        }
       
        boolean[] sol = new boolean[sumS/2+1]; //initialize solution array with size as half of S
         
        sol[0] = true; //empty Set S
        for (int i : S) {
            for (int j=sumS/2 ; j>=i ; j--) {
                if (sol[j-i])
                    sol[j] = true; 
            }
        }      
        int x = sumS/2;
        while(!sol[x])
            x--;
        System.out.println ("The Minimum sumS After partioning the S is :" +(sumS-2*x));    
    }
}