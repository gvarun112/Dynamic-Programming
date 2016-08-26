package grandfinale;
import java.util.Scanner;
public class Problem10C {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Dices:");
        int numberofDices = sc.nextInt(); //enter the number of dices
        System.out.println("Enter number of Faces:");
        int numberofFaces = sc.nextInt(); //enter the number of faces
        System.out.println("Enter sum:");
        int sum = sc.nextInt(); //enter the sum to be found
        int solution = dice(numberofDices, numberofFaces, sum); 
        System.out.println("soltuion:"+solution);
    }

    private static int dice(int numberofDices, int numberofFaces, int sum) {
        int matrix[][] = new int[numberofFaces+1][sum+1]; //create a 2D matrix with number of faces and sum
        
        for(int i = 0 ; i <= numberofDices && i <= sum ; i++) {
                matrix[1][i] = 1; //initialize the 1st row of matrix with 1
        }
        
        for(int i = 2 ; i <= numberofFaces ; i++) {
            for(int j = 1 ; j <= sum ; j++) {
                for(int k = 1 ; k <= numberofDices && k < j ; k++) {
                    matrix[i][j] = matrix[i][j]+matrix[i-1][j-k];
                }
            }
        }
        return matrix[numberofFaces][sum]; //return the matrix
    }
}
