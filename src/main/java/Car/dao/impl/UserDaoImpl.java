package Car.dao.impl;


import Car.dao.UserDao;
import Car.entity.Question;
import Car.entity.Test;
import Car.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) throws Exception {
        openSession().save(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        openSession().update(user);
    }


    @Override
    public List getAllUsers() throws Exception {
        String sql = "SELECT * FROM usser";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.addEntity(User.class);
        return query.list();
    }

    @Override
    public void deleteUser(User user) throws Exception {
        openSession().delete(user);
    }

    @Override
    public List findOne(int id) throws Exception {
        String sql = "SELECT * FROM usser WHERE usser.User_id = :id";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setInteger("id", id);
        query.addEntity(User.class);
        return query.list();
    }

    @Override
    public void saveUser(User user) throws Exception {
        openSession().save(user);
    }

    @Override
    public User getUserByLogin(String userLogin) throws Exception {
        String sql =
                "SELECT * " +
                "FROM usser u " +
                "WHERE u.Login = :userLogin";
        SQLQuery query = openSession().createSQLQuery(sql);
        query.setParameter("userLogin", userLogin);
        query.addEntity(User.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (User) query.list().get(0);
    }

}
