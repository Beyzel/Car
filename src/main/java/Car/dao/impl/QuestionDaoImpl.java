package Car.dao.impl;

import Car.dao.QuestionDao;
import Car.entity.Question;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Question getQuestion(Integer questionId) throws Exception {
        String sql =
                "SELECT * " +
                        "FROM question q " +
                        "WHERE q.question_id = :questionId";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("questionId", questionId);
        query.addEntity(Question.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Question) query.list().get(0);
    }
}
