import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UniversityDBManager db = new UniversityDBManager();

        while (true) {
            System.out.println("\n UNIVERSITY DATABASE SYSTEM ");
            System.out.println("1. Add Professor     2. List Professors");
            System.out.println("3. Add Course        4. List All Courses");
            System.out.println("5. Filter by Dept    6. Exit");
            System.out.print("Select (1-6): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("First Name: "); String n = sc.nextLine();
                    System.out.print("Surname: "); String s = sc.nextLine();
                    System.out.print("Email: "); String e = sc.nextLine();
                    System.out.print("Department: "); String d = sc.nextLine();
                    db.saveProfessor(new Professor(n, s, e, d));
                }
                case 2 -> db.listAllProfessors();
                case 3 -> {
                    System.out.println("\nTip: Use Option 2 to find Professor IDs.");
                    System.out.print("Course Code: "); String code = sc.nextLine();
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Credits: "); int creds = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Department: ");  String cDept = sc.nextLine();
                    System.out.print("Professor ID: ");int pId = sc.nextInt();
                    db.saveCourse(new Course(code, title, creds, cDept, null), pId);
                }
                case 4 -> db.listAllCourses();
                case 5 -> {
                    System.out.print("Enter Department Name to filter: ");
                    db.filterCoursesByDept(sc.nextLine());
                }
                case 6 -> {
                    System.out.println("Exiting System...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}