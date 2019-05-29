package Controller;

import DBModel.UserTB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DBController {
    @PersistenceContext
    private EntityManager em;
    
    public void add(UserTB u) {
        em.persist(u);
    }
    
    public UserTB getUser(String name, String pass) {
        return em
                .createQuery("SELECT u FROM UserTB u WHERE u.userName = :name and u.pass = :pass", UserTB.class)
                .setParameter("name", name)
                .setParameter("pass", pass)
                .getSingleResult();
    }
}
