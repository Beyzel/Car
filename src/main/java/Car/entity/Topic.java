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
    private Set<Topic> topics = new HashSet<>(0);

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

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }


}