package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(String name, String lastName, String email);
    void removeUser(int id);
    User getUser(int id);
    void updateUser(int id, String name, String lastName, String email);
}
