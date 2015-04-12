package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "ticket_id")
//    @NotEmpty
    private Integer Ticket_id;

    @Column(name = "topic_id")
//    @NotEmpty
    private Integer Topic_id;

    @Column(name = "date")
    @NotEmpty
    @DateTimeFormat
    private Date date;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "Test_id")
    private List<UserAnswer> userAnswers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "Topic_id")
    private Topic topic;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
