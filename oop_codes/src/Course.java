public class Course {
    private String courseCode;
    private String title;
    private int credit;
    private String department;
    private Professor lecturer;
    public Course(String courseCode, String title, int credit, String department, Professor lecturer) {
        this.courseCode = courseCode;
        this.title = title;
        this.credit = credit;
        this.department = department;
        this.lecturer = lecturer;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getTitle() {
        return title;
    }
    public int getCredit() {
        return credit;
    }
    public String getDepartment() {
        return department;
    }
    public Professor getLecturer() {
        return lecturer;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Course code : " + courseCode + ", Title : " + title + ", Credit hours: " + credit + ", Department : " + department;
    }
}