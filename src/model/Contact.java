package model;

public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private Long telefone;

    public Contact(String firstName, String lastName, String email, Long telefone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telefone = telefone;
    }

    public Contact(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
