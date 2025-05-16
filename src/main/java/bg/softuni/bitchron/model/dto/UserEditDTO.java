package bg.softuni.bitchron.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserEditDTO {
    @NotNull
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String country;

    @NotBlank
    private String cityOrState;

    @NotNull
    private Integer postalCode;

    @NotBlank
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public UserEditDTO setId(Long id) {
        this.id = id;

        return this;
    }

    public UserEditDTO setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEditDTO setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEditDTO setEmail(String email) {
        this.email = email;

        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEditDTO setPhone(String phone) {
        this.phone = phone;

        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserEditDTO setCountry(String country) {
        this.country = country;

        return this;
    }

    public String getCityOrState() {
        return cityOrState;
    }

    public UserEditDTO setCityOrState(String cityOrState) {
        this.cityOrState = cityOrState;

        return this;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public UserEditDTO setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;

        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEditDTO setAddress(String address) {
        this.address = address;

        return this;
    }
}
