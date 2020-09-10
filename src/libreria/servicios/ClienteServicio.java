
package libreria.servicios;

import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

public class ClienteServicio {
    
    ClienteDAO dao = new ClienteDAO();
    
    public void guardar(int documento,String nombre, String apellido, String domicilio,String telefono){
        Cliente cliente = new Cliente();
        cliente.setDocumento(documento);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);
        dao.guardar(cliente);
        
    }
    
    public Cliente buscarPorDocumento(int doc){
        return dao.buscarPorDocumento(doc);
    }
    
    
}
