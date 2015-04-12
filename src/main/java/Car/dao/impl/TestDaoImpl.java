package Car.dao.impl;

import Car.dao.TestDao;
import Car.entity.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Ticket> getAllTickets() throws Exception {
        String sql =
                "SELECT * " +
                        "FROM ticket";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.addEntity(Ticket.class);
        return query.list();
    }

    @Override
    public List<Topic> getAllTopics() throws Exception {
        String sql =
                "SELECT * " +
                        "FROM topic t " +
                        "WHERE t.Topic_id IN (SELECT DISTINCT q.topic_id " +
                        "FROM question q)";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.addEntity(Topic.class);
        return query.list();
    }

    @Override
    public void addNewTicketTest(Integer userId, Date date, Integer ticketId) throws Exception {
        final String sql =
                "INSERT INTO test (user_id, Ticket_id, date) " +
                        "VALUES(:userId, :ticketId, :date)";

        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("ticketId", ticketId);
        query.setParameter("date", date);
        query.executeUpdate();
    }

    @Override
    public void addNewTopicTest(Integer userId, Date date, Integer topicId) throws Exception {
        final String sql =
                "INSERT INTO test (user_id, Topic_id, date)\n" +
                        "VALUES(:userId, :topicId, :date)";

        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("topicId", topicId);
        query.setParameter("date", date);
        query.executeUpdate();
    }

    @Override
    public Integer getTestTicketId(Integer userId, Date date, Integer ticketId) throws Exception {
        String sql =
                "SELECT * \n" +
                        "FROM test t \n" +
                        "WHERE t.user_id = :userId AND t.date = :date AND t.Ticket_id = :ticketId ";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("date", date);
        query.setParameter("ticketId", ticketId);
        query.addEntity(Test.class);
        List<Test> ans = query.list();

        return ((Test) ans.get(ans.size() - 1)).getTest_id();
    }

    @Override
    public Integer getTestTopicId(Integer userId, Date date, Integer topicId) throws Exception {
        String sql =
                "SELECT * \n" +
                        "FROM test t \n" +
                        "WHERE t.user_id = :userId AND t.date = :date AND t.Topic_id = :topicId ";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("date", date);
        query.setParameter("topicId", topicId);
        query.addEntity(Test.class);
        List<Test> ans = query.list();

        return ((Test) ans.get(ans.size() - 1)).getTest_id();
    }

    @Override
    public void insertUserAnswers(List<Integer> answers, Integer userId, Integer testId) throws Exception {
        final String sql =
                "INSERT INTO user_answer (user_id, test_id, question_id, answer_id) " +
                        "VALUES(:userId, :testId, " +
                        "(SELECT a.question_id " +
                        "FROM answer a " +
                        "WHERE a.answer_id = :answerId), :answerId)";

        Session session = openSession();
        for (Integer answer : answers) {
            final SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setParameter("userId", userId);
            sqlQuery.setParameter("testId", testId);
            sqlQuery.setParameter("answerId", answer);
            sqlQuery.executeUpdate();
        }
    }

    @Override
    public List<Test> getUserTickets(Integer userId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM test t\n" +
                        "WHERE t.user_id = :userId AND t.Ticket_id IN (SELECT Ticket_id\n" +
                        "FROM ticket)";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.addEntity(Test.class);
        return query.list();
    }

    @Override
    public List<UserAnswer> getUserTestAnswers(Integer userId) throws Exception {
        String sql =
                "SELECT * " +
                        "FROM user_answer ua " +
                        "WHERE ua.test_id IN (SELECT t.test_id " +
                        "FROM test t " +
                        "WHERE t.user_id = :userId)";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.addEntity(UserAnswer.class);
        return query.list();
    }

    @Override
    public Test checkIfTicketWasPassedBefore(Integer userId, Integer ticketId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM test t\n" +
                        "WHERE t.user_id = :userId AND t.Ticket_id = :ticketId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("ticketId", ticketId);
        query.addEntity(Test.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<Test> list = query.list();
        if (list.isEmpty()) {
            return new Test();
        }
        return list.get(0);
    }

    @Override
    public Test checkIfTopicWasPassedBefore(Integer userId, Integer topicId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM test t\n" +
                        "WHERE t.user_id = :userId AND t.Topic_id = :topicId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("topicId", topicId);
        query.addEntity(Test.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<Test> list = query.list();
        if (list.isEmpty()) {
            return new Test();
        }
        return list.get(0);
    }

    @Override
    public void deleteTest(Integer testId) throws Exception {
        final String sql =
                "DELETE FROM test " +
                        "WHERE test_id = :testId ";
        final SQLQuery sqlQuery = openSession().createSQLQuery(sql);
        sqlQuery.setParameter("testId", testId);
        sqlQuery.executeUpdate();
    }

    @Override
    public List<Test> getUserTopics(Integer userId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM test t\n" +
                        "WHERE t.user_id = :userId AND t.Topic_id IN (SELECT Topic_id\n" +
                        "FROM topic)";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.addEntity(Test.class);
        return query.list();
    }

    @Override
    public Answer getAnswer(Integer answerId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM answer a\n" +
                        "WHERE a.answer_id = :answerId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("answerId", answerId);
        query.addEntity(Answer.class);
        query.setFirstResult(0);
        query.setMaxResults(1);

        return (Answer) query.list().get(0);
    }

    @Override
    public List<Question> getTicketQuestions(Integer ticketId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM question q\n" +
                        "WHERE q.ticket_id = :ticketId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("ticketId", ticketId);
        query.addEntity(Question.class);
        return query.list();
    }

    @Override
    public List<Question> getTopicQuestions(Integer topicId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM question q\n" +
                        "WHERE q.topic_id = :topicId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("topicId", topicId);
        query.addEntity(Question.class);
        return query.list();
    }

    @Override
    public Question getQuestion(Integer questionId) throws Exception {
        String sql =
                "SELECT *\n" +
                        "FROM question q\n" +
                        "WHERE q.question_id = :questionId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("questionId", questionId);
        query.addEntity(Question.class);
        query.setFirstResult(0);
        query.setMaxResults(1);

        return (Question) query.list().get(0);
    }
}
