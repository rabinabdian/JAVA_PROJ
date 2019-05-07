public class Employee extends Person {

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String lastName;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    int employeeNumber;


    public void setPersonName(String firstName, String lastName, Person person) {
        this.name = person.name;
        this.lastName=lastName;


    }
}
