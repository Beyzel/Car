package Car.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Usser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_id")
    private int User_id;

    @Column(name = "Login")
    @Size(min = 1, max = 20)
    @NotNull
    private String Login;

    @Column(name = "Mail")
    @NotEmpty
    @Email
    private String Mail;

    @Column(name = "Password")
    @Size(min = 1, max = 16)
    @NotNull
    private String Password;

    @Column(name = "user_role_id")
    private Integer user_role_id;

//    @ManyToOne
//    @JoinColumn(name = "User_role_id")
//    private UserRole userRole;

    @OneToMany
    @JoinColumn(name = "test_id")
    private Set<Test> tests = new HashSet<>(0);

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

//    public UserRole getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(UserRole userRole) {
//        this.userRole = userRole;
//    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }
}
