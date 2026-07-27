import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-example-pu");

        EntityManager em = emf.createEntityManager();

        System.out.println("Connected successfully!");

        em.close();
        emf.close();
    }
}
//
//Add to persistente.xml:
//<class>com.example.entity.User</class>
//<class>com.example.entity.UserDetails</class>
//<class>com.example.Flight</class>
//<class>com.example.entity.Booking</class>