package exercise;

public class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV csv;

    public EmployeeCSVAdapter(EmployeeCSV csv) {
        this.csv = csv;
    }

    @Override
    public String getId() {
        String[] tokens = csv.tokens();
        return tokens[0];
    }

    @Override
    public String getFirstName() {
        String[] tokens = csv.tokens();
        return tokens[1];
    }

    @Override
    public String getLastName() {
        String[] tokens = csv.tokens();
        return tokens[2];
    }

    @Override
    public String getEmail() {
        String[] tokens = csv.tokens();
        return tokens[3];
    }

}
