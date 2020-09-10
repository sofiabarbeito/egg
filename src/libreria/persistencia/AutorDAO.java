
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorDAO {     
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LIbreriaPU");
    private EntityManager em = emf.createEntityManager();
    private int atributo;

    
    public void guardar(Autor autor) {

        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        
    }

    public List<Autor> buscarAutores() {EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        return em.createQuery("SELECT a FROM Autor a ORDER BY a.nombre ").getResultList();
    }
    
    public Autor buscarAutor(String id){EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        return (Autor) em.find(Autor.class, id);
    }
    
    public Autor buscarAutorPorNombre(String nombre){
        
        return (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre").setParameter("nombre",nombre).getSingleResult();
    }
    
    public void modificar(Autor autor) {EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();

        em.merge(autor);

        em.getTransaction().commit();
    }

    public void eliminar(Autor autor) {EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();
        
        em.remove(autor);
        
        em.getTransaction().commit();
    }
}
