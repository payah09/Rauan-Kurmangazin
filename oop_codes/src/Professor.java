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
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.specialty = specialty;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    @Override
    public String toString() {

    }
}
