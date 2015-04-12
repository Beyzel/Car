package Car.service;


import Car.entity.*;

import java.sql.Date;
import java.util.List;

public interface TestService {

    public List<Ticket> getAllTickets() throws Exception;

    public List<Topic> getAllTopics() throws Exception;

    public void addNewTicketTest(Integer userId, Date date, Integer ticketId) throws Exception;

    public void addNewTopicTest(Integer userId, Date date, Integer topicId) throws Exception;

    public Integer getTestTicketId(Integer userId, Date date, Integer ticketId) throws Exception;

    public Integer getTestTopicId(Integer userId, Date date, Integer topicId) throws Exception;

    public void insertUserAnswers(List<Integer> answers, Integer userId, Integer testId) throws Exception;

    public List<Test> getUserTickets(Integer userId) throws Exception;

    public List<UserAnswer> getUserTestAnswers(Integer userId) throws Exception;

    public Test checkIfTicketWasPassedBefore(Integer userId, Integer ticketId) throws Exception;

    public Test checkIfTopicWasPassedBefore(Integer userId, Integer topicId) throws Exception;

    public void deleteTest(Integer testId) throws Exception;

    public List<Test> getUserTopics(Integer userId) throws Exception;

    public Answer getAnswer(Integer answerId) throws Exception;

    public List<Question> getTicketQuestions(Integer ticketId) throws Exception;

    public List<Question> getTopicQuestions(Integer topicId) throws Exception;

    public Question getQuestion(Integer questionId) throws Exception;
}
