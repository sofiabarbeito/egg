
package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Prestamo;

public class PrestamoDAO {
    EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
    
    public void guardar(Prestamo prestamo){
        em.getTransaction().begin();
        
        em.persist(prestamo);
        
        em.getTransaction().commit();
    }
    
    public Prestamo buscarPorId(String id){
        return (Prestamo) em.createQuery("SELECT a FROM Prestamo a WHERE a.id = :id").setParameter("id",id).getSingleResult();
    
    }
}
