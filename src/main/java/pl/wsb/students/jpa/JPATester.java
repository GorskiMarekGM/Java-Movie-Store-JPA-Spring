package pl.wsb.students.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class JPATester {
    private static final String PERSISTENCE_UNIT_NAME = "manager";
    public static void createNewEntity() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        MoviePerson newMoviePerson = new MoviePerson();
        newMoviePerson.setCreated(new Date());
        newMoviePerson.setModified(new Date());
        newMoviePerson.setFirstName("Movie Person");
        newMoviePerson.setLastName("Test");
        em.persist(newMoviePerson);
        em.getTransaction().commit();
        em.close();
    }
    public static void listEntities() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        TypedQuery<MoviePerson> query = em.createQuery("select mp from MoviePerson mp", MoviePerson.class);

        List<MoviePerson> moviePeople = query.getResultList();

        for (MoviePerson moviePerson : moviePeople) {
            System.out.println(moviePerson);
        }
        em.close();
    }
}