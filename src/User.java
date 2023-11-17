import lombok.Getter;

@Getter
public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int age;

    public User(String email, String firstName, String lastName, String password, int age) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isValid() {
        return (this.email.matches("[a-zA-Z0-9_]@[a-zA-Z0-9][.][a-z]{2,3}") &&
                !this.firstName.isEmpty() && !this.lastName.isEmpty() &&
                (this.password.length() > 8 && this.password.length() < 40) &&
                this.password.matches("\\d") &&
                this.password.matches("[a-z]") &&
                this.password.matches("[A-Z]") &&
                this.age > 13);
    }
}
