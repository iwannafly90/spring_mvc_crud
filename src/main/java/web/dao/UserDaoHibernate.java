package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoHibernate implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        TypedQuery<User> typedQuery = entityManager.createQuery(" from User u", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public void addUser(String name, String lastName, String email) {
        User user = new User(name, lastName, email);
        entityManager.persist(user);
    }

    @Override
    public void removeUser(int id) {
        User user = getUser(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, String name, String lastName, String email) {
        User user = getUser(id);
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        entityManager.merge(user);
    }
}
