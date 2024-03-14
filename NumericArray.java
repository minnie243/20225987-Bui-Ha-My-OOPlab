import java.util.Arrays;
import java.util.Scanner;

public class NumericArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Set the length of the array: ");
        int n = input.nextInt();
        double[] arr = new double[n];
        System.out.println("Enter the array: ");
        for(int i=0; i<n; i++){
            arr[i]=input.nextDouble();
        }
        //Sort the array
        Arrays.sort(arr);
        System.out.println("Sorted array: ");
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        //Calculate the sum
        double sum=0;
        for(double num : arr){
            sum+=num;
        }

        //Calculate the average
        double average = sum/arr.length;

        System.out.println("Sum = "+sum);
        System.out.println("Average = "+average);
    }
}
