public abstract class Person {
    private final int id;
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email) {
        this.id = generateId();
        setName(name);
        setSurname(surname);
        setEmail(email);
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Warning: Invalid email format!");
            this.email = "unknown@uni.edu";
        }
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown"; // Default value
            System.out.println("Error: Name cannot be empty.");
        } else {
            this.name = name.trim();
        }
    }
    public void setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            this.surname = "Unknown";
            System.out.println("Error: Surname cannot be empty.");
        } else {
            this.surname = surname.trim();
        }
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getEmail() { return email; }

    // Helper for ID generation
    private static int idCounter = 1;
    private synchronized int generateId() { return idCounter++; }

    public abstract String getRole();

    @Override
    public String toString() {
        return "[" + getRole() + " ID: " + id + "] " + name + " " + surname + " (" + email + ")";
    }
}