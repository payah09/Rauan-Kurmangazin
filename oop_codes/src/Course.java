import java.util.Objects;

public class Course {
    private String courseCode;
    private String title;
    private int credits;
    private String department;
    private Professor professor;

    public Course(String courseCode, String title, int credits, String department, Professor professor) {
        setCourseCode(courseCode);
        setTitle(title);
        setCredits(credits);
        setDepartment(department);
        this.professor = professor;
    }
    public void setCourseCode(String courseCode) {
        if (courseCode != null && courseCode.length() > 2) {
            this.courseCode = courseCode.toUpperCase();
        } else {
            this.courseCode = "000";
            System.out.println("Error: Invalid Course Code.");
        }
    }
    public void setTitle(String title) {
        this.title = (title != null) ? title : "Untitled Course";
    }
    public void setCredits(int credits) {
        if (credits > 0) {
            this.credits = credits;
        } else {
            this.credits = 1;
            System.out.println("Error: Credits must be above zero.");
        }
    }
    public void setDepartment(String department) {
        this.department = (department != null) ? department.toUpperCase() : "GENERAL";
    }
    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return courseCode + ", " + title + ", Credits: " + credits + ", Department: " + department + " Professor: " + professor.getName() + professor.getSurname();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}