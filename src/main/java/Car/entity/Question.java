package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @Column(name = "question_id")
    @NotEmpty
    private int Question_id;

    @Column(name = "ticket_id")
    @NotEmpty
    private int Ticket_id;

    @Column(name = "topic_id")
    @NotEmpty
    private int Topic_id;

    @Column(name = "question")
    @Size(min = 5, max = 2000)
    @NotEmpty
    private String Question;

    @Column(name = "help")
    @Size(min = 5, max = 2000)
    @NotEmpty
    private String Help;

    @Column(name = "image")
    @NotEmpty
    private Blob Image;

    @ManyToOne
    @JoinColumn(name = "Ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "Topic_id")
    private Topic topic;

    @OneToMany
    @JoinColumn(name = "Question_id")
    private Set<Answer> answers  = new HashSet<>(0);

    @OneToMany
    @JoinColumn(name = "Question_id")
    private Set<UserAnswer> userAnswers  = new HashSet<>(0);

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public int getQuestion_id() {
        return Question_id;
    }

    public void setQuestion_id(int question_id) {
        Question_id = question_id;
    }

    public int getTicket_id() {
        return Ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        Ticket_id = ticket_id;
    }

    public int getTopic_id() {
        return Topic_id;
    }

    public void setTopic_id(int topic_id) {
        Topic_id = topic_id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getHelp() {
        return Help;
    }

    public void setHelp(String help) {
        Help = help;
    }

    public Blob getImage() {
        return Image;
    }

    public void setImage(Blob image) {
        Image = image;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public void checkAndSetAnswers(List<Answer> allAnswers) {

        answers = new HashSet<>();

        for(Iterator<Answer> i = allAnswers.iterator(); i.hasNext(); ) {

            final Answer answer = i.next();

            if(answer.getQuestion_id() == Question_id) {
                answers.add(answer);
            }
        }

    }
}
