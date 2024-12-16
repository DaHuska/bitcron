package bg.softuni.bitchron.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class UserRegisterDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String username;

    @NotEmpty

    @NotEmpty
    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
