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

//    @NotNull
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<UserRole> roles = new ArrayList<>();
    // TODO: 'Many To Many' attribute value type should not be 'UserRole'

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public @NotNull Date getCreated() {
        return created;
    }

    public void setCreated(@NotNull Date created) {
        this.created = created;
    }

    public @NotNull Date getModified() {
        return modified;
    }

    public void setModified(@NotNull Date modified) {
        this.modified = modified;
    }
}
