package Car.dao;

import Car.entity.Question;
import Car.entity.Ticket;

import java.util.List;

public interface TicketDao {
    public List getTicketQuestions(Integer ticketId)throws Exception;
    public List getAnswersToTicketQuestions(Integer ticketId) throws Exception;
}
