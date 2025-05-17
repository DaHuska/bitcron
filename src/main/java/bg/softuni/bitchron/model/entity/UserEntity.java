package bg.softuni.bitchron.model.entity;

import bg.softuni.bitchron.model.validation.DateNotInTheFuture;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column
    private String username;

    @NotBlank
    @Column
    private String password;

    @Column
    @Email
    private String email;

    @Column
    private String phone;

    @Column
    private String country;

    @Column(name = "city_or_state")
    private String cityOrState;

    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private String address;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<UserRoleEntity> roles = new ArrayList<>();

    @DateNotInTheFuture
    @NotNull
    @Column
    private Date created = new Date();

    @DateNotInTheFuture
    @NotNull
    @Column
    private Date modified = new Date();

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;

        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;

        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public Date getCreated() {
        return created;
    }

    public UserEntity setCreated(Date created) {
        this.created = created;

        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;

        return this;
    }

    public Date getModified() {
        return modified;
    }

    public UserEntity setModified(Date modified) {
        this.modified = modified;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;

        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;

        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserEntity setCountry(String country) {
        this.country = country;

        return this;
    }

    public String getCityOrState() {
        return cityOrState;
    }

    public UserEntity setCityOrState(String cityOrState) {
        this.cityOrState = cityOrState;

        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public UserEntity setPostalCode(String postalCode) {
        this.postalCode = postalCode;

        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;

        return this;
    }
}
