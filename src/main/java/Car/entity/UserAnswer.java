package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User_Answer")
public class UserAnswer implements Serializable {

    @Id
    @Column(name = "User_id")
    @NotEmpty
    private int User_id;

    @Id
    @Column(name = "Test_id")
    @NotEmpty
    private int Test_id;

    @Id
    @Column(name = "Question_id")
    @NotEmpty
    private int Question_id;

    @Id
    @Column(name = "Answer_id")
    @NotEmpty
    private int Answer_id;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "Test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "Answer_id")
    private Answer answer;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getTest_id() {
        return Test_id;
    }

    public void setTest_id(int test_id) {
        Test_id = test_id;
    }

    public int getQuestion_id() {
        return Question_id;
    }

    public void setQuestion_id(int question_id) {
        Question_id = question_id;
    }

    public int getAnswer_id() {
        return Answer_id;
    }

    public void setAnswer_id(int answer_id) {
        Answer_id = answer_id;
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
}
