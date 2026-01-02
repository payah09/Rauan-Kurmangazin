import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        University uni = new University("Astana IT University");
        Professor p1 = new Professor("Kairat", "Nurtas", "kn@uni.kz", "CS");
        Professor p2 = new Professor("Beksultan", "Seifula", "bs@uni.kz", "BDA");
        Professor p3 = new Professor("Elena", "Ivanova", "elena.i@uni.kz", "MATH");
        Professor p4 = new Professor("Alan", "Turing", "alan.t@uni.kz", "CS");
        Professor p5 = new Professor("Sarah", "Connor", "sarah.c@uni.kz", "PHYSICS");

        uni.addCourse(new Course("CS101", "Java Programming", 5, "CS", p1));
        uni.addCourse(new Course("CS202", "Data Structures", 6, "CS", p4));
        uni.addCourse(new Course("CS301", "Web Development", 4, "CS", p1));

        uni.addCourse(new Course("BD101", "Database Systems", 3, "BDA", p2));
        uni.addCourse(new Course("BD205", "Data Mining", 5, "BDA", p2));

        uni.addCourse(new Course("MTH11", "Calculus I", 4, "MATH", p3));
        uni.addCourse(new Course("MTH12", "Linear Algebra", 3, "MATH", p3));
        uni.addCourse(new Course("PHY50", "Quantum Mechanics", 2, "PHYSICS", p5));

        while (true) {
            System.out.println("   UNIVERSITY MANAGEMENT SYSTEM");
            System.out.println("1. Display All Courses");
            System.out.println("2. Search by Course Code");
            System.out.println("3. Filter by Department");
            System.out.println("4. Sort by Credits (High to Low)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> uni.displayAll();
                case 2 -> {
                    System.out.print("Enter Course Code (e.g., CS101): ");
                    uni.searchByCode(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Enter Department (CS, BDA, MATH, PHYSICS): ");
                    uni.filterByDepartment(sc.nextLine());
                }
                case 4 -> uni.sortByCredits();
                case 5 -> {
                    System.out.println("Thank you for using the system. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}