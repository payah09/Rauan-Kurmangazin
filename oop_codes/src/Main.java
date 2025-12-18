public class Main {
    public static void main(String[] args) {
        Professor[] prof = new Professor[2];
        Course[] courses = new Course[2];
        prof[0] = new Professor("Kairat", "Nurtas", "kairatN@gmail.com");
        prof[1] = new Professor("Beksultan", "Seifula", "beksultanS@gmail.com");
        courses[0] = new Course("CS-101", "Intro to CS", 5, "Comp. Sci.", prof[0]);
        courses[1] = new Course("BDA-101", "DBMS", 5, "BDA", prof[1]);
        University AITU = new University("AITU", 2);
        AITU.addCourse(courses[0]);
        AITU.addCourse(courses[1]);
        AITU.displayInfo();
    }
}