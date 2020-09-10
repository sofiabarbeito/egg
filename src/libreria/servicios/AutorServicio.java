package libreria.servicios;

import java.util.List;
import java.util.UUID;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {
    
    private AutorDAO dao = new AutorDAO();

    public void guardar(String nombre) {
        Autor autor = new Autor();
        autor.setId(UUID.randomUUID().toString());
        autor.setNombre(nombre);
        
        dao.guardar(autor);
    }

    public List<Autor> buscarAutores() {
        return dao.buscarAutores();
    }
    
    public Autor buscarAutor(String id){
        return dao.buscarAutor(id);
    }

    public Autor buscarAutorPorNombre(String nombre){
        return dao.buscarAutorPorNombre(nombre);
    }
    
    public void modificar(String id, String nombre) {
        Autor autor = dao.buscarAutor(id);
        autor.setNombre(nombre);
        dao.modificar(autor);
    }

    public void eliminar(String id) {
        Autor autor = dao.buscarAutor(id);
        dao.eliminar(autor);
    }

}
