package Car.service.impl;

import Car.dao.TicketDao;
import Car.entity.Answer;
import Car.entity.Question;
import Car.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDao ticketDao;

    @Override
    public List<Question> getTicketQuestions(Integer ticketId) throws Exception {
        return ticketDao.getTicketQuestions(ticketId);
    }

    @Override
    public List<Answer> getAnswersToTicketQuestions(Integer ticketId) throws Exception {
        return ticketDao.getAnswersToTicketQuestions(ticketId);
    }
}
