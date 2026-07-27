import jakarta.persistence.*;

import java.util.List;

public class UserService {

    private EntityManagerFactory emf;

    public UserService() {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }


    public void createUser(User user) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();

        em.close();
    }


    public List<User> getAllUsers() {

        EntityManager em = emf.createEntityManager();

        List<User> users = em.createQuery(
                "SELECT u FROM User u",
                User.class
        ).getResultList();

        em.close();

        return users;
    }


    public User getUserById(Long id) {

        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, id);

        em.close();

        return user;
    }


    public void updateUser(User user) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(user);

        em.getTransaction().commit();

        em.close();
    }


    public void deleteUser(Long id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, id);

        if (user != null) {
            em.remove(user);
        }

        em.getTransaction().commit();

        em.close();
    }
}