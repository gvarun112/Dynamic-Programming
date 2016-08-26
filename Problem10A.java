package grandfinale;

import java.util.ArrayList;
import java.util.Random;

public class Problem10A { 
    
    static ArrayList<Integer> v = new ArrayList();
    static boolean player = true; //if true, player1. Else , player2.
    static int[] p1;
    static int[] p2;
    static int j=0,k=0,n;
    
    public static void main(String[] args) {
        
        Random r = new Random();      
        for (int i=0;i<6;i++)
            v.add(r.nextInt(100)); //enter the values into the array
        
        p1 = new int[v.size()/2]; //initialize player1 
        p2 = new int[v.size()/2]; //initialize player2
        
        System.out.println(v.toString());
        
        n = v.size();
        solve(); //call the function
        
        int maxAmount = 0;
        for(int i=0 ; i<p1.length ; i++){
            maxAmount += p1[i];
            System.out.println(p1[i]+" "+p2[i]);
        }
        
        System.out.println("Maximum possible amount that Player 1 can get: "+maxAmount);
    }

    private static void solve() {
        if (player) {
            if(v.get(0) >= v.get(v.size()-1)) { //check if 1st element of the array is greater than or equal to last element
                p1[j] = v.get(0); //enter the 1st element into player1 array
                v.remove(0); //remove the 1st element
            }
            else {
                p1[j] = v.get(v.size()-1); //enter last element into player 1
                v.remove(v.size()-1); //remove the last from the array
            }
            j++; 
            player = false; //make the player value as false so that the next round goes to player2
        }
        else {
            if(v.get(0) >= v.get(v.size()-1)) { //check if 1st element of the array is greater than or equal to last element
                p2[k] = v.get(0); //enter the 1st element into player2 array
                v.remove(0); //remove the 1st element
            }
            else {
                p2[k] = v.get(v.size()-1); //enter last element into player 2
                v.remove(v.size()-1); //remove the last from the array
            }
            k++;
            player = true;
        }
        if(!v.isEmpty())
            solve(); //make a recursive call to the same function
    }
}