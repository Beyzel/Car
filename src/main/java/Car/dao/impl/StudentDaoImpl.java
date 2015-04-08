package Car.dao.impl;


import Car.dao.StudentDao;
import Car.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addStudent() throws Exception {
        String sql = "INSERT INTO student VALUES ((SELECT MAX(usser.User_id) FROM usser))";
        openSession().createSQLQuery(sql).executeUpdate();
    }
}
