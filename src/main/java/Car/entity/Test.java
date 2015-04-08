package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    @NotEmpty
    private Integer Test_id;

    @Column(name = "user_id")
    @NotEmpty
    private int User_id;

    @Column(name = "date")
    @NotEmpty
    @DateTimeFormat
    private Date date;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Student student;

    @OneToMany
    @JoinColumn(name = "Test_id")
    private List<UserAnswer> userAnswers  = new ArrayList<>();


    public Integer getTest_id() {
        return Test_id;
    }

    public void setTest_id(Integer test_id) {
        Test_id = test_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public void resetUserAnswers() {
        userAnswers = new ArrayList<>();
    }

    public void addUserAnswer(UserAnswer userAnswer) {
        userAnswers.add(userAnswer);
    }
}
