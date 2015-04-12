package Car.service;

import Car.entity.User;

import java.util.List;

public interface UserService {

    public void addUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public List<User> findOne(int id) throws Exception;

    public List<User> getAllUsers() throws Exception;

    public void deleteUser(User user) throws Exception;

    public void saveUser(User user) throws Exception;

    public User getUserByLogin(String userLogin) throws Exception;
}
