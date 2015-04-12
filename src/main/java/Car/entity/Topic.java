package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Topic")
public class Topic {

    @Id
    @Column(name = "topic_id")
    @NotEmpty
    private int Topic_id;

    @Column(name = "Topic_Name")
    @Size(min = 5, max = 300)
    @NotNull
    private String TopicName;

    @OneToMany
    @JoinColumn(name = "Topic_id")
    private Set<Question> questions = new HashSet<>(0);

    @OneToMany
    @JoinColumn(name = "Topic_id")
    private Set<Test> tests = new HashSet<>(0);

    public int getTopic_id() {
        return Topic_id;
    }

    public void setTopic_id(int topic_id) {
        Topic_id = topic_id;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String topicName) {
        TopicName = topicName;
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