package Car.service.impl;

import Car.dao.TestDao;
import Car.entity.*;
import Car.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Ticket> getAllTickets() throws Exception {
        return testDao.getAllTickets();
    }

    @Override
    public List<Topic> getAllTopics() throws Exception {
        return testDao.getAllTopics();
    }

    @Override
    public void addNewTicketTest(Integer userId, Date date, Integer ticketId) throws Exception {
        testDao.addNewTicketTest(userId, date, ticketId);
    }

    @Override
    public void addNewTopicTest(Integer userId, Date date, Integer topicId) throws Exception {
        testDao.addNewTopicTest(userId, date, topicId);
    }

    @Override
    public Integer getTestTicketId(Integer userId, Date date, Integer ticketId) throws Exception {
        return testDao.getTestTicketId(userId, date, ticketId);
    }

    @Override
    public Integer getTestTopicId(Integer userId, Date date, Integer topicId) throws Exception {
        return testDao.getTestTopicId(userId, date, topicId);
    }

    @Override
    public void insertUserAnswers(List<Integer> answers, Integer userId, Integer testId) throws Exception {
        testDao.insertUserAnswers(answers, userId, testId);
    }

    @Override
    public List<Test> getUserTickets(Integer userId) throws Exception {
        return testDao.getUserTickets(userId);
    }

    @Override
    public List<UserAnswer> getUserTestAnswers(Integer userId) throws Exception {
        return testDao.getUserTestAnswers(userId);
    }

    @Override
    public Test checkIfTicketWasPassedBefore(Integer userId, Integer ticketId) throws Exception {
        return testDao.checkIfTicketWasPassedBefore(userId, ticketId);
    }

    @Override
    public void deleteTest(Integer testId) throws Exception {
        testDao.deleteTest(testId);
    }

    @Override
    public Test checkIfTopicWasPassedBefore(Integer userId, Integer topicId) throws Exception {
        return testDao.checkIfTopicWasPassedBefore(userId, topicId);
    }

    @Override
    public List<Test> getUserTopics(Integer userId) throws Exception {
        return testDao.getUserTopics(userId);
    }

    @Override
    public Answer getAnswer(Integer answerId) throws Exception {
        return testDao.getAnswer(answerId);
    }

    @Override
    public List<Question> getTicketQuestions(Integer ticketId) throws Exception {
        return testDao.getTicketQuestions(ticketId);
    }

    @Override
    public List<Question> getTopicQuestions(Integer topicId) throws Exception {
        return testDao.getTopicQuestions(topicId);
    }

    @Override
    public Question getQuestion(Integer questionId) throws Exception {
        return testDao.getQuestion(questionId);
    }
}
