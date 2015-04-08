package Car.dao;

import Car.entity.Topic;

import java.util.List;

public interface TopicDao {
    public Topic getTopic(Integer topicId) throws Exception;
    public List getTopicQuestions(Integer topicId) throws Exception;
    public List getAnswersToTopicQuestions(Integer topicId) throws Exception;
}
