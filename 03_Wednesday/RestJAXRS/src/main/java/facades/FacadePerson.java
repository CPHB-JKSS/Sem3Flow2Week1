package facades;

import entities.Person;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * 
 */
public class FacadePerson {

    private static FacadePerson instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadePerson() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadePerson getFacadePerson(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadePerson();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    
    @Override
    public PersonDTO deletePerson(int id) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        PersonDTO p = getPerson(id);

        Person pp = em.find(Person.class, id);

        try {
            em.getTransaction().begin();
            em.remove(pp);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }
    
    @Override
    public PersonDTO editPerson(PersonDTO p) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, p.getId());
        if (person == null) {
            throw new IllegalArgumentException("Person with ID: " + p.getId() + " not found");
        }
        person.setfName(p.getfName());
        person.setlName(p.getlName());
        person.setPhone(p.getPhone());
        person.setLastEdited(new Date());

        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
            return new PersonDTO(person);
        } finally {
            em.close();
        }
    }
    
    
    
    
    
    
    
    //TODO Remove/Change this before use
    public long getPersonCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

}
