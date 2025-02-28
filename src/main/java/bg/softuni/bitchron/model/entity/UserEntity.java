package bg.softuni.bitchron.model.entity;

import bg.softuni.bitchron.model.validation.DateNotInTheFuture;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import bg.softuni.bitchron.model.enums.UserRole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @NotEmpty
    @Column
    private String username;

    @NotEmpty
    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<UserRoleEntity> roles = new ArrayList<>();

    @NotNull
    @DateNotInTheFuture
    @Column
    private Date created;

    @NotNull
    @DateNotInTheFuture
    @Column
    private Date modified;

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
}
