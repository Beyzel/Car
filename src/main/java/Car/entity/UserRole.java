package Car.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_role_id")
    private int User_role_id;

    @Column(name = "Role")
    @Size(min = 1, max = 20)
    @NotNull
    private String Role;

    @OneToMany
    @JoinColumn(name = "User_role_id")
    private Set<User> users = new HashSet<>(0);

    public int getUser_role_id() {
        return User_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        User_role_id = user_role_id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
