import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int total = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            total += marks;
        }

       
        double average = (double) total / n;
        System.out.printf("Average Percentage: %.2f%%\n", average);

        
        int score = (int) average / 10;

        switch (score) {
            case 10:
            case 9:
                if (average == 100)
                    System.out.println("Grade: A+ (Perfect)");
                else
                    System.out.println("Grade: A+");
                break;

            case 8:
                if (average >= 85)
                    System.out.println("Grade: A (Excellent)");
                else
                    System.out.println("Grade: A");
                break;

            case 7:
                System.out.println("Grade: B+");
                break;

            case 6:
                System.out.println("Grade: B");
                break;

            case 5:
                System.out.println("Grade: C");
                break;

            case 4:
                System.out.println("Grade: D");
                break;

            default:
                System.out.println("Grade: F (Fail)");
        }
    }
}

