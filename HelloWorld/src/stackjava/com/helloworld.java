import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a month (e.g., January, Jan., Jan, 1): ");
            String monthInput = scanner.nextLine().toLowerCase();
            System.out.print("Enter a year (e.g., 1999): ");
            int year;
            try {
                year = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid year.");
                continue;
            }

            int month;
            switch (monthInput) {
                case "january":
                case "jan.":
                case "jan":
                case "1":
                    month = 1;
                    break;
                case "february":
                case "feb.":
                case "feb":
                case "2":
                    month = 2;
                    break;
                case "march":
                case "mar.":
                case "mar":
                case "3":
                    month = 3;
                    break;
                case "april":
                case "apr.":
                case "apr":
                case "4":
                    month = 4;
                    break;
                case "may":
                case "5":
                    month = 5;
                    break;
                case "june":
                case "jun.":
                case "jun":
                case "6":
                    month = 6;
                    break;
                case "july":
                case "jul.":
                case "jul":
                case "7":
                    month = 7;
                    break;
                case "august":
                case "aug.":
                case "aug":
                case "8":
                    month = 8;
                    break;
                case "september":
                case "sep.":
                case "sep":
                case "9":
                    month = 9;
                    break;
                case "october":
                case "oct.":
                case "oct":
                case "10":
                    month = 10;
                    break;
                case "november":
                case "nov.":
                case "nov":
                case "11":
                    month = 11;
                    break;
                case "december":
                case "dec.":
                case "dec":
                case "12":
                    month = 12;
                    break;
                default:
                    System.out.println("Invalid month input. Please enter a valid month.");
                    continue;
            }

            if (year < 0) {
                System.out.println("Invalid year. Please enter a non-negative year.");
            } else {
                int daysInMonth = getDaysInMonth(month, year);
                System.out.println("Number of days in the selected month: " + daysInMonth);
                break;
            }
        }
        System.exit(0);
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1; // Invalid month
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}