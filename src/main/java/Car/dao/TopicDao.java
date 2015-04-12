package Car.dao;

import Car.entity.Answer;
import Car.entity.Question;
import Car.entity.Topic;

import java.util.List;

public interface TopicDao {
    public Topic getTopic(Integer topicId) throws Exception;

    public List<Question> getTopicQuestions(Integer topicId) throws Exception;

    public List<Answer> getAnswersToTopicQuestions(Integer topicId) throws Exception;
}
