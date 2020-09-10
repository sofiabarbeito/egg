package libreria.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;
import libreria.persistencia.LibroDAO;

public class LibroServicio {
    
    private LibroDAO dao = new LibroDAO();
    private AutorDAO daoAutor = new AutorDAO();
    private EditorialDAO daoEditorial = new EditorialDAO();

    public void guardar(Integer isbn, String titulo, Integer anio, String idAutor, String idEditorial, Integer ejemplares) {

        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(0);
        libro.setAnio(anio);

        Autor autor = daoAutor.buscarAutor(idAutor);
        libro.setAutor(autor);
        
        Editorial editorial = daoEditorial.buscarEditorial(idEditorial);
        libro.setEditorial(editorial);
        
        dao.guardar(libro);
    }
    
    
    public void actualizarEjemplares(Integer isbn, Integer ejemplares) {


        Libro libro = dao.buscarLibro(isbn);
        libro.setEjemplares(ejemplares);
        dao.actualizarEjemplares(libro);
    }
    
    public List<Libro> buscarLibros(){
        return dao.buscarLibros();
    }
    
    public Libro buscarLibro(Integer isbn){
        return dao.buscarLibro(isbn);
    }
    
    
    public List<Libro> buscarLibrosPorTitulo(String titulo){
        
        return dao.buscarLibrosPorTitulo(titulo);
    }

    public List<Libro> buscarLibrosPorAutor(String autor){
        
        return dao.buscarLibrosPorAutor(autor);
    }
    
}