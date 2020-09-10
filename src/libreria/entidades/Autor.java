package libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {
    
    @Id
    private String id;
   
    private String nombre;

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public String toString() {
        return nombre;
    }
    
    
            
}
