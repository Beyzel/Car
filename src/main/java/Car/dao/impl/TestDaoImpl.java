package Car.dao.impl;

import Car.dao.TestDao;
import Car.entity.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List getAllTickets() throws Exception {
        String sql =
                "SELECT * " +
                "FROM ticket";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.addEntity(Ticket.class);
        return query.list();
    }

    @Override
    public List getAllTopics() throws Exception {
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
    public void addNewTest(Integer userId, Date date) throws Exception {
        final String sql =
                "INSERT INTO test (user_id, date) " +
                        "VALUES(:userId, :date)";

        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("date", date);
        query.executeUpdate();
    }

    @Override
    public Integer getTestId(Integer userId, Date date) throws Exception {
        String sql =
                "SELECT * " +
                        "FROM test t " +
                        "WHERE t.user_id = :userId AND t.date = :date " +
                        "AND t.test_id NOT IN (SELECT ua.test_id " +
                        "FROM user_answer ua " +
                        "WHERE ua.user_id = :userId) ";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("date", date);
        query.addEntity(Test.class);
        List<Test> ans = query.list();

        return ans.get(ans.size()-1).getTest_id();
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
        for(int i = 0; i < answers.size(); i++) {
            final SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setParameter("userId", userId);
            sqlQuery.setParameter("testId", testId);
            sqlQuery.setParameter("answerId", answers.get(i));
            sqlQuery.executeUpdate();
        }
    }

    @Override
    public List getUserTickets(Integer userId) throws Exception {
        String sql = "SELECT * " +
                "FROM test t " +
                "WHERE t.user_id = :userId AND (SELECT count(1) " +
                                         "FROM question q JOIN user_answer ua ON (q.question_id = ua.question_id) " +
                                         "WHERE ua.test_id = t.test_id) = " +
                                        "(SELECT count(1) " +
                                         "FROM question q1 " +
                                         "WHERE q1.ticket_id = (SELECT q2.ticket_id " +
                                                               "FROM question q2 JOIN user_answer ua1 ON (q2.question_id = ua1.question_id) " +
                                                               "WHERE ua1.test_id = t.test_id " +
                                                               "GROUP BY 1 " +
                                                               "LIMIT 1))";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.addEntity(Test.class);
        return query.list();
    }

    @Override
    public List getUserTestAnswers(Integer userId) throws Exception {
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
                "SELECT t.* " +
                "FROM test t JOIN user_answer ua ON (t.test_id = ua.test_id) JOIN question q ON (ua.question_id = q.question_id) " +
                "WHERE t.user_id = :userId AND q.ticket_id = :ticketId " +
                "\tAND (SELECT count(t1.test_id)\n" +
                "\t\t  FROM test t1 JOIN user_answer ua1 ON (t1.test_id = ua1.test_id)\n" +
                "\t\t  WHERE t1.test_id = t.test_id\n" +
                "\t\t  GROUP BY t1.test_id) \n" +
                "\t= \n" +
                "\t\t(SELECT count(1)\n" +
                "\t\tFROM question q1\n" +
                "\t\tWHERE q1.ticket_id = q.ticket_id)\n" +
                "GROUP BY t.test_id";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("ticketId", ticketId);
        query.addEntity(Test.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List list = query.list();
        if(list.isEmpty()) {
            return new Test();
        }
        return (Test) list.get(0);
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
    public Test checkIfTopicWasPassedBefore(Integer userId, Integer topicId) throws Exception {
        String sql =
                "SELECT t.*\n" +
                "FROM test t JOIN user_answer ua ON (t.test_id = ua.test_id) JOIN question q ON (ua.question_id = q.question_id)\n" +
                "WHERE t.user_id = :userId AND q.topic_id = :topicId \n" +
                "\tAND (SELECT count(t1.test_id)\n" +
                "\t\t  FROM test t1 JOIN user_answer ua1 ON (t1.test_id = ua1.test_id)\n" +
                "\t\t  WHERE t1.test_id = t.test_id\n" +
                "\t\t  GROUP BY t1.test_id) \n" +
                "\t= \n" +
                "\t\t(SELECT count(1)\n" +
                "\t\tFROM question q1\n" +
                "\t\tWHERE q1.topic_id = q.topic_id)\n" +
                "GROUP BY t.test_id";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("topicId", topicId);
        query.addEntity(Test.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List list = query.list();
        if(list.isEmpty()) {
            return new Test();
        }
        return (Test) list.get(0);
    }

    @Override
    public List getUserTopics(Integer userId) throws Exception {
        String sql =
                "SELECT * \n" +
                "FROM test t \n" +
                "WHERE t.user_id = :userId AND (SELECT count(1) \n" +
                "\t\t\t\t\t\t\t\t FROM question q JOIN user_answer ua ON (q.question_id = ua.question_id) \n" +
                "\t\t\t\t\t\t\t\t WHERE ua.test_id = t.test_id) \n" +
                "\t\t\t\t\t\t\t\t = \n" +
                "\t\t\t\t\t\t\t\t(SELECT count(1) \n" +
                "\t\t\t\t\t\t\t\t FROM question q1 \n" +
                "\t\t\t\t\t\t\t\t WHERE q1.topic_id = (SELECT q2.topic_id\n" +
                "\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\t  FROM question q2 JOIN user_answer ua1 ON (q2.question_id = ua1.question_id) \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  WHERE ua1.test_id = t.test_id \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  GROUP BY 1 \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  LIMIT 1))";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.addEntity(Test.class);
        return query.list();
    }
}
