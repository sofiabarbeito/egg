package libreria.servicios;

import java.util.List;
import java.util.UUID;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {
    
    private EditorialDAO dao = new EditorialDAO();

    public void guardar(String nombre) {
        Editorial editorial = new Editorial();
        editorial.setId(UUID.randomUUID().toString());
        editorial.setNombre(nombre);
        
        dao.guardar(editorial);

    }

    public List<Editorial> buscarEditoriales() {
        return dao.buscarEditoriales();
    }

    public Editorial buscarEditorial(String id){
        return dao.buscarEditorial(id);
    }
    
    public void modificar(String id, String nombre) {

        Editorial editorial = dao.buscarEditorial(id);
        editorial.setNombre(nombre);
        dao.modificar(editorial);
    }

    public void eliminar(String id) {
        Editorial editorial = dao.buscarEditorial(id);
        dao.eliminar(editorial);
    }

}
