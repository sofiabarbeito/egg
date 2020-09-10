
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;


public class EditorialDAO {

    
    public void guardar(Editorial editorial) {

        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public List<Editorial> buscarEditoriales() {
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        return em.createQuery("SELECT a FROM Editorial a ORDER BY a.nombre ").getResultList();
    }

    public Editorial buscarEditorial(String id){
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        return (Editorial) em.find(Editorial.class, id);
    }
    
    public void modificar(Editorial editorial) {
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();

        em.merge(editorial);

        em.getTransaction().commit();
    }

    public void eliminar(Editorial editorial) {
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();
        
        em.remove(editorial);
        
        em.getTransaction().commit();
    }
}
