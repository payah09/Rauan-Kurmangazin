public class Professor extends Person {
    private String department;

    public Professor(String name, String surname, String email, String department) {
        super(name, surname, email);
        setDepartment(department);
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return super.toString() + ", Dept: " + department;
    }
}