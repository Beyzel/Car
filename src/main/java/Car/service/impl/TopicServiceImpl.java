package Car.service.impl;

import Car.dao.TopicDao;
import Car.entity.Answer;
import Car.entity.Question;
import Car.entity.Topic;
import Car.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;


    @Override
    public Topic getTopic(Integer topicId) throws Exception {
        return topicDao.getTopic(topicId);
    }

    @Override
    public List<Question> getTopicQuestions(Integer topicId) throws Exception {
        return topicDao.getTopicQuestions(topicId);
    }

    @Override
    public List<Answer> getAnswersToTopicQuestions(Integer topicId) throws Exception {
        return topicDao.getAnswersToTopicQuestions(topicId);
    }
}
