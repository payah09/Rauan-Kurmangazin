public class Course {
    private String courseCode;
    private String title;
    private int credit;
    private String department;
    private Professor professor;
    public Course(String courseCode, String title, int credit, String department, Professor professor) {
        setCourseCode(courseCode);
        setTitle(title);
        setCredit(credit);
        setDepartment(department);
        this.professor = professor;
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
    public String getProfessor() {
        return professor.toString();
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
        return "Course code : " + courseCode + ", Title : " + title + ", Credit hours: " + credit + ", Department : " + department + ", " + professor.toString();
    }
}