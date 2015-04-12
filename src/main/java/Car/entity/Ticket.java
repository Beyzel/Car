package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @NotEmpty
    private int Ticket_id;

    @OneToMany
    @JoinColumn(name = "Ticket_id")
    private Set<Question> questions = new HashSet<>(0);

    @OneToMany
    @JoinColumn(name = "Ticket_id")
    private Set<Test> tests = new HashSet<>(0);

    public int getTicket_id() {
        return Ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        Ticket_id = ticket_id;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
}

