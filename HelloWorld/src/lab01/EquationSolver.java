import java.util.Scanner;
public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Equation Solver:\n1. Solve a linear equation: ax + b = 0\n2. Solve a system of first-degree equation: a11x1 + a12x2 = b1 and a21x1 + a22x2 = b2\n3. Solve a quadratic equation: ax^2 + bx + c = 0\n");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                solveLinearEquation();
                break;
            case 2:
                solveSystemOfFirstDegreeEquation();
                break;
            case 3:
                solveQuadraticEquation();
                break;
            default:
                break;
        }
    }
    public static void solveLinearEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the values of a");
        double a = scanner.nextDouble();
        System.out.println("Please enter the values of b");
        double b = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solutions");
            } else {
                System.out.println("The equation has no solution");
            }
        } else {
            System.out.println("The equation has one solution: " + (-b / a));
        }
    }
    public static void solveSystemOfFirstDegreeEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the values of a11");
        double a11 = scanner.nextDouble();
        System.out.println("Please enter the values of a12");
        double a12 = scanner.nextDouble();
        System.out.println("Please enter the values of b1");
        double b1 = scanner.nextDouble();
        System.out.println("Please enter the values of a21");
        double a21 = scanner.nextDouble();
        System.out.println("Please enter the values of a22");
        double a22 = scanner.nextDouble();
        System.out.println("Please enter the values of b2");
        double b2 = scanner.nextDouble();
        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinite solutions");
            } else {
                System.out.println("The system has no solution");
            }
        } else {
            System.out.println("The system has one solution: " + "x1 = " + (D1 / D) + " and x2 = " + (D2 / D));
        }
    }
    public static void solveQuadraticEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the values of a");
        double a = scanner.nextDouble();
        System.out.println("Please enter the values of b");
        double b = scanner.nextDouble();
        System.out.println("Please enter the values of c");
        double c = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The equation has infinite solutions");
                } else {
                    System.out.println("The equation has no solution");
                }
            } else {
                System.out.println("The equation has one solution: " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("The equation has no solution");
            } else if (delta == 0) {
                System.out.println("The equation has one solution: " + (-b / (2 * a)));
            } else {
                System.out.println("The equation has two solutions: " + ((-b + Math.sqrt(delta)) / (2 * a)) + " and " + ((-b - Math.sqrt(delta)) / (2 * a)));
            }
        }
    }
}