import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Course> coursePool;
    public University(String name) {
        this.name = name;
        this.coursePool = new ArrayList<>();
    }
    public void addCourse(Course c) {
        coursePool.add(c);
    }
    public void searchByCode(String code) {
        for (Course c : coursePool) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                System.out.println("Found: " + c);
                return;
            }
        }
        System.out.println("Course not found.");
    }
    public void filterByDepartment(String dept) {
        System.out.println("Courses in " + dept + ":");
        for (Course c : coursePool) {
            if (c.getDepartment().equalsIgnoreCase(dept)) {
                System.out.println(c);
            }
        }
    }
    public void sortByCredits() {
        coursePool.sort((a, b) -> Integer.compare(b.getCredits(), a.getCredits()));
        System.out.println("Sorted by credits (Highest first):");
        displayAll();
    }
    public void displayAll() {
        for (Course c : coursePool) {
            System.out.println(c);
        }
    }
}