package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @Column(name = "Answer_id")
    @NotEmpty
    private int Answer_id;

    @Column(name = "question_id")
    @NotEmpty
    private int Question_id;

    @Column(name = "answer_text")
    @Size(min = 5, max = 300)
    @NotNull
    private String AnswerText;

    @Column(name = "correct")
    @NotEmpty
    private boolean Correct;

    @ManyToOne
    @JoinColumn(name = "Question_id")
    private Question question;

    @OneToMany
    @JoinColumn(name = "Answer_id")
    private Set<UserAnswer> userAnswers = new HashSet<>(0);


    public int getAnswer_id() {
        return Answer_id;
    }

    public void setAnswer_id(int answer_id) {
        Answer_id = answer_id;
    }

    public int getQuestion_id() {
        return Question_id;
    }

    public void setQuestion_id(int question_id) {
        Question_id = question_id;
    }

    public String getAnswerText() {
        return AnswerText;
    }

    public void setAnswerText(String answerText) {
        AnswerText = answerText;
    }

    public boolean isCorrect() {
        return Correct;
    }

    public void setCorrect(boolean correct) {
        Correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }


}
