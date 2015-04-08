package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {


    @Id
    @Column(name = "user_id")
    @NotEmpty
    private int User_id;

    @OneToMany
    @JoinColumn(name = "User_id")
    private Set<Test> tests = new HashSet<>(0);

    @OneToMany
    @JoinColumn(name = "User_id")
    private Set<UserAnswer> userAnswers  = new HashSet<>(0);


    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private User user;

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
