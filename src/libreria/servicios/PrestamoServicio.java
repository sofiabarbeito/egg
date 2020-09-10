
package libreria.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.ClienteDAO;
import libreria.persistencia.LibroDAO;
import libreria.persistencia.PrestamoDAO;

public class PrestamoServicio {
    PrestamoDAO dao = new PrestamoDAO();
    LibroDAO daoLibro = new LibroDAO();
    ClienteDAO daoCliente = new ClienteDAO();
    
    public void guardar(String fecha,String devolucion,List<Integer> id_libros,int doc_cliente){
        Prestamo prestamo = new Prestamo();
        prestamo.setId(UUID.randomUUID().toString());
        prestamo.setFecha(fecha);
        prestamo.setDevolucion(devolucion);
        
        List<Libro> libros = new ArrayList();
        for(Integer i: id_libros){
            Libro libro = daoLibro.buscarLibro(i);
            libro.setEjemplares(libro.getEjemplares()-1);
            libro.setPrestados(libro.getPrestados()+1);
            libros.add(libro);
        }
        prestamo.setLibros(libros);
        
        Cliente cliente = daoCliente.buscarPorDocumento(doc_cliente);
        prestamo.setCliente(cliente);
        
        dao.guardar(prestamo);
        
    }
    
    public Prestamo buscarPorId(String id){
        return dao.buscarPorId(id);
    }
}
