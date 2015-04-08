package Car.service;


import Car.entity.Test;
import Car.entity.Ticket;

import java.sql.Date;
import java.util.List;

public interface TestService {

    public List getAllTickets() throws Exception;
    public List getAllTopics() throws Exception;
    public void addNewTest(Integer userId, Date date) throws Exception;
    public Integer getTestId(Integer userId, Date date) throws Exception;
    public void insertUserAnswers(List<Integer> answers, Integer userId, Integer testId) throws Exception;
    public List getUserTickets(Integer userId) throws Exception;
    public List getUserTestAnswers(Integer userId) throws Exception;
    public Test checkIfTicketWasPassedBefore(Integer userId, Integer ticketId) throws Exception;
    public void deleteTest(Integer testId) throws Exception;
    public Test checkIfTopicWasPassedBefore(Integer userId, Integer topicId) throws Exception;
    public List getUserTopics(Integer userId) throws Exception;

}
