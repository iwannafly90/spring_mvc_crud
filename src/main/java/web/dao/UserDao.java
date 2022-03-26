package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void addUser(String name, String lastName, String email);
    void removeUser(int id);
    User getUser(int id);
    void updateUser(int id, String name, String lastName, String email);
}
