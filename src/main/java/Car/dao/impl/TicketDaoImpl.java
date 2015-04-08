package Car.dao.impl;

import Car.dao.TicketDao;
import Car.entity.Answer;
import Car.entity.Question;
import Car.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.Iterator;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List getTicketQuestions(Integer ticketId) throws Exception {
        String sql =
                "SELECT * " +
                "FROM question q " +
                "WHERE q.ticket_id = :ticketId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("ticketId", ticketId);
        query.addEntity(Question.class);
        return query.list();
    }

    @Override
    public List getAnswersToTicketQuestions(Integer ticketId) throws Exception {
        String sql =
                "SELECT * " +
                "FROM answer a " +
                "WHERE a.question_id IN (SELECT q.question_id " +
                                        "FROM question q " +
                                        "WHERE q.ticket_id = :ticketId)";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("ticketId", ticketId);
        query.addEntity(Answer.class);
        return query.list();
    }
}
