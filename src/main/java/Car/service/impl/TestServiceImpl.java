package Car.service.impl;

import Car.dao.TestDao;
import Car.entity.Test;
import Car.entity.Ticket;
import Car.service.TestService;
import jdk.nashorn.internal.objects.NativeRegExp;
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
    public List getAllTickets() throws Exception {
        return testDao.getAllTickets();
    }

    @Override
    public List getAllTopics() throws Exception {
        return testDao.getAllTopics();
    }

    @Override
    public void addNewTest(Integer userId, Date date) throws Exception {
        testDao.addNewTest(userId, date);
    }

    @Override
    public Integer getTestId(Integer userId, Date date) throws Exception {
        return testDao.getTestId(userId, date);
    }

    @Override
    public void insertUserAnswers(List<Integer> answers, Integer userId, Integer testId) throws Exception {
        testDao.insertUserAnswers(answers, userId, testId);
    }

    @Override
    public List getUserTickets(Integer userId) throws Exception {
        return testDao.getUserTickets(userId);
    }

    @Override
    public List getUserTestAnswers(Integer userId) throws Exception {
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
    public List getUserTopics(Integer userId) throws Exception {
        return testDao.getUserTopics(userId);
    }
}
