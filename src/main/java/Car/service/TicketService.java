package Car.service;

import Car.entity.Answer;
import Car.entity.Question;

import java.util.List;

public interface TicketService {
    public List<Question> getTicketQuestions(Integer ticketId) throws Exception;

    public List<Answer> getAnswersToTicketQuestions(Integer ticketId) throws Exception;
}
