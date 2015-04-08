package Car.service.impl;

import Car.entity.Test;
import Car.entity.User;
import Car.dao.UserDao;
import Car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    public void addUser(User user) throws Exception {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDAO.updateUser(user);
    }

    @Override
    public List getAllUsers() throws Exception {
        return userDAO.getAllUsers();
    }

    @Override
    public void deleteUser(User user) throws Exception {
        userDAO.deleteUser(user);
    }

    @Override
    public List findOne(int id) throws Exception {
        return userDAO.findOne(id);
    }

    @Override
    public void saveUser(User user) throws Exception {
        userDAO.saveUser(user);
    }

    @Override
    public User getUserByLogin(String userLogin) throws Exception {
        return userDAO.getUserByLogin(userLogin);
    }
}
