public class University {
    private String uniName;
    private Course[] courses;
    private int courseCount;

    public University(String uniName, int capacity) {
        setUniName(uniName);
        this.courses = new Course[capacity];
        this.courseCount = 0;
    }
    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount] = course;
            courseCount++;
        } else {
            System.out.println("Error: University capacity reached. Cannot add " + course.getTitle());
        }
    }
    public String getUniName() {
        return uniName;
    }
    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public void displayInfo() {
        System.out.println(uniName + "Available courses:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println((i + 1) + ". " + courses[i]);
        }
    }
}