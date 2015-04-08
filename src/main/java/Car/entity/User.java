package Car.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_id")
    private int User_id;

    @OneToOne
    @JoinColumn(name = "User_id")
    private Admin admin;

    @OneToOne
    @JoinColumn(name = "User_id")
    private Student student;

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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}
