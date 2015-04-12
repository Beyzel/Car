package Car.dao;

import Car.entity.Answer;
import Car.entity.Question;

import java.util.List;

public interface TicketDao {
    public List<Question> getTicketQuestions(Integer ticketId) throws Exception;

    public List<Answer> getAnswersToTicketQuestions(Integer ticketId) throws Exception;
}
