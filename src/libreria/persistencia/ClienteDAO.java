

package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Cliente;

public class ClienteDAO {
    EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
    
    public void guardar(Cliente cliente){
        
        em.getTransaction().begin();
        
        em.persist(cliente);
        
        em.getTransaction().commit();
        
    }
    
    public Cliente buscarPorDocumento(int doc){
        return (Cliente) em.createQuery("SELECT a FROM Cliente a WHERE a.documento = :doc").setParameter("doc",doc).getSingleResult();
    }
}
