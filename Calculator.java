import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        String strNum1 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);
        System.out.println("Enter the second number: ");
        String strNum2 = scanner.nextLine();
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1*num2;
        double quotient = 0;
        if(num2!=0){
            quotient=num1/num2;
        }
        else {
            System.out.println("Cannot divide by zero.");
            System.exit(1);
        }
        System.out.println("Sum = "+sum);
        System.out.println("Difference = "+difference);
        System.out.println("Product = "+product);
        System.out.println("Quotient = "+quotient);
        scanner.close();
    }
}
