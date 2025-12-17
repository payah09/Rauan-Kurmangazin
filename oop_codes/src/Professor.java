public class Professor {
    private int id;
    private static int id_counter = 0;
    private String name;
    private String surname;
    private String email;
    private String specialty;
    Professor() {
        id = id_counter++;
    }
    Professor(String name, String surname, String email, String specialty) {
        this();
        setName(name);
        setSurname(surname);
        setEmail(email);
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Professor: " + name + " " + surname + ", email: " + email;
    }
}
