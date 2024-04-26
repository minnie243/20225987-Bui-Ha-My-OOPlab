import java.util.Scanner;
public class AddTwoMatrices {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of row and column: ");
        int row = input.nextInt();
        int column = input.nextInt();
        double[][] matrix1 = new double[row][column];
        double[][] matrix2 = new double[row][column];
        double[][] sum = new double[row][column];
        System.out.println("Enter the first matrix: ");
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                matrix1[i][j] = input.nextDouble();
            }
        }
        System.out.println("Enter the second matrix: ");
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                matrix2[i][j] = input.nextDouble();
            }
        }
        System.out.println("Sum: ");
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                sum[i][j]=matrix1[i][j]+matrix2[i][j];
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
