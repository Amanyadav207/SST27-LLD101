package exercise;

public class EmployeeDBAdapter implements Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public EmployeeDBAdapter(EmployeeDB db) {
        this.id = db.getId();
        this.firstName = db.getFirstName();
        this.lastName = db.getSurname();
        this.email = db.getEmailAddress();
    }


    @Override
    public String getId() {
        return String.valueOf(id);
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }
}

