import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    if (name.isEmpty() || grade.isEmpty() || email.isEmpty()) {
                        System.out.println(" All fields are required.");
                        break;
                    }

                    sms.addStudent(new Student(name, rollNo, grade, email));
                }
                case 2 -> {
                    System.out.print("Enter roll number to remove: ");
                    int roll = sc.nextInt();
                    if (!sms.removeStudent(roll)) {
                        System.out.println(" Student not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter roll number to search: ");
                    int roll = sc.nextInt();
                    Student s = sms.searchStudent(roll);
                    if (s != null) {
                        System.out.println(" Found: " + s);
                    } else {
                        System.out.println(" Student not found.");
                    }
                }
                case 4 -> sms.displayAllStudents();
                case 5 -> {
                    System.out.print("Enter roll number to edit: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New name: ");
                    String name = sc.nextLine();
                    System.out.print("New grade: ");
                    String grade = sc.nextLine();
                    System.out.print("New email: ");
                    String email = sc.nextLine();

                    sms.editStudent(roll, name, grade, email);
                }
                case 6 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }
}

