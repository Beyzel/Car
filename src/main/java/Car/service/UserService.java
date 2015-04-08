package Car.service;

import Car.entity.Test;
import Car.entity.User;

import java.sql.Date;
import java.util.List;

public interface UserService {

    public void addUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public List findOne(int id) throws Exception;
    public List getAllUsers() throws Exception;
    public void deleteUser(User user) throws Exception;
    public void saveUser(User user) throws Exception;
    public User getUserByLogin(String userLogin) throws Exception;
}
