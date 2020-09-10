
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Libro;

public class LibroDAO {

    public void guardar(Libro libro) {

        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();
        
        em.persist(libro);
        
        em.getTransaction().commit();
    }
    
    
    public void actualizarEjemplares(Libro libro) {

        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();

        em.persist(libro);
        
        em.getTransaction().commit();
    }
    
    public List<Libro> buscarLibros(){
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();  
        List<Libro> libros = em.createQuery("SELECT c FROM Libro c ORDER BY c.titulo").getResultList();
        return libros;
    }
    
    public Libro buscarLibro(Integer isbn){
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        return (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.isbn = :isbn").setParameter("isbn",isbn).getSingleResult();
    }
    
    
    public List<Libro> buscarLibrosPorTitulo(String titulo){
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();  
        
        List<Libro> libros = em.createQuery("SELECT c FROM Libro c WHERE c.titulo LIKE :titulo")
                .setParameter("titulo", "%" + titulo + "%")
                .getResultList();
        
        return libros;
    }

    public List<Libro> buscarLibrosPorAutor(String autor){
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();  
        
        List<Libro> libros = em.createQuery("SELECT c FROM Libro c WHERE c.autor.nombre LIKE :nombre ORDER BY c.titulo")
                .setParameter("nombre", "%" + autor + "%")
                .getResultList();
        
        return libros;
    }
}
