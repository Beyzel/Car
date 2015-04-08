package Car.dao.impl;

import Car.dao.TopicDao;
import Car.entity.Answer;
import Car.entity.Question;
import Car.entity.Topic;
import Car.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicDaoImpl implements TopicDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Topic getTopic(Integer topicId) throws Exception {
        String sql =
                "SELECT * " +
                "FROM topic t " +
                "WHERE t.Topic_id = :topicId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("topicId", topicId);
        query.addEntity(Topic.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Topic) query.list().get(0);
    }

    @Override
    public List getTopicQuestions(Integer topicId) throws Exception {
        String sql =
                "SELECT * " +
                "FROM question q " +
                "WHERE q.topic_id = :topicId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("topicId", topicId);
        query.addEntity(Question.class);
        return query.list();
    }

    @Override
    public List getAnswersToTopicQuestions(Integer topicId) throws Exception {
        String sql = "SELECT * " +
                "FROM answer a " +
                "WHERE a.question_id IN (SELECT q.question_id " +
                                        "FROM question q " +
                                        "WHERE q.topic_id = :topicId)";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("topicId", topicId);
        query.addEntity(Answer.class);
        return query.list();
    }
}
