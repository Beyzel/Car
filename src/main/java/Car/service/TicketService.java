package Car.service;

import Car.entity.Question;
import java.util.List;

public interface TicketService {
    public List getTicketQuestions(Integer ticketId)throws Exception;
    public List getAnswersToTicketQuestions(Integer ticketId) throws Exception;
}
