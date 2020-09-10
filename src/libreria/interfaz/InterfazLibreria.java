package libreria.interfaz;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.entidades.Autor;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;

public class InterfazLibreria {
    

    private EditorialServicio editorialServicio;
    private AutorServicio autorServicio;
    private LibroServicio libroServicio;
    private ClienteServicio clienteServicio;
    private PrestamoServicio prestamoServicio;
    
    private BufferedReader teclado;
    
    public InterfazLibreria() {
        this.editorialServicio = new EditorialServicio();
        this.autorServicio = new AutorServicio();
        this.libroServicio = new LibroServicio();
        this.prestamoServicio = new PrestamoServicio();
        this.clienteServicio = new ClienteServicio();
        this.teclado = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String leerCadena(){
        String cadena = null;
        try {
            cadena = teclado.readLine();
        } catch (IOException ex) {
            Logger.getLogger(InterfazLibreria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }
    
    
    public Integer leerNumero(){
        String cadena = "0";
        try {
            cadena = teclado.readLine();
        } catch (IOException ex) {
            Logger.getLogger(InterfazLibreria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Integer(cadena);
    }
    
    
    public void menu(){
        System.out.println("Seleccione la opción:");
        System.out.println("=====================================");
        
        System.out.println(" 1- Crear Autor");
        System.out.println(" 2- Crear Editorial");
        System.out.println(" 3- Crear Libro");
        System.out.println(" 4- Agregar Ejemplares");
        
        System.out.println(" 5- Mostrar Libros");
        System.out.println(" 6- Mostrar Libros x Autor");
        System.out.println(" 7- Mostrar Libros x Titulo");
        System.out.println(" 8- Mostrar Libros x ISBN");

        System.out.println(" 9- Prestamo");
        System.out.println(" 10- Devolución");
        
        System.out.println(" 11- Crear Cliente");
        System.out.println(" 12- Agregar libros a un prestamo");
        
        System.out.println(" 0- Salir");
        
                
        int opcion = leerNumero();
        switch(opcion){
            case 1: 
                crearAutor();
                break;
            case 2:
                crearEditorial();
                break;
            case 3:
                crearLibro();
                break;
            case 4:
                agregarEjemplar();
                break;
            case 5:      
                mostrarLibros();
                break;
            case 6:      
                mostrarLibrosDeAutor();
                break;
            case 7:      
                mostrarLibrosPorTitulo();
                break;
            case 8:      
                mostrarLibrosPorISBN();
                break;
            case 9:      
                prestamo();
                break;
            case 10:      
                devolucion();
                break;
            case 11:
                crearCliente();
                break;
            case 0:
                System.exit(-1);
                break;
        }
        
    }
    
    public void crearAutor(){
        System.out.println("Ingrese nombre del autor:");
        String nombre = leerCadena();
        autorServicio.guardar(nombre);
        
    }
    
    public void crearEditorial(){
        System.out.println("Ingrese nombre de la editorial:");
        String nombre = leerCadena();
        editorialServicio.guardar(nombre);
        
    }
    
    public void crearLibro(){
        System.out.println("Ingrese ISBN del libro:");
        Integer isbn = leerNumero();
        

        System.out.println("Ingrese titulo del libro:");
        String titulo = leerCadena();
        
        
        System.out.println("Ingrese el año de publicacion del libro:");
        Integer anio = leerNumero();
        

        System.out.println("Ingrese el autor:");
        String Autor = leerCadena();
        
        Autor autor = autorServicio.buscarAutorPorNombre(Autor);
        String idAutor = autor.getId();
        
        System.out.println("Ingrese ID de editorial:");
        String idEditorial = leerCadena();
 
        System.out.println("Ingrese la cantidad de ejemplares:");
        Integer ejemplares = leerNumero();
 
        
        libroServicio.guardar(isbn, titulo, anio, idAutor, idEditorial, ejemplares);
    }
    
    public void agregarEjemplar(){
        System.out.println("Ingrese ISBN del libro:");
        Integer isbn = leerNumero();
 
        System.out.println("Ingrese la cantidad de ejemplares:");
        Integer ejemplares = leerNumero();

        libroServicio.actualizarEjemplares(isbn, ejemplares);
    }
    
    public void mostrarLibros(){
        List<Libro> libros = libroServicio.buscarLibros();
        imprimirLibros(libros);
    }


    public void mostrarLibrosDeAutor(){
 
        System.out.println("Ingrese el nombre del autor:");
        String autor = leerCadena();
        
        List<Libro> libros = libroServicio.buscarLibrosPorAutor(autor);
        imprimirLibros(libros);
    }
    
    public void mostrarLibrosPorISBN(){
        
        System.out.println("Ingrese ISBN del libro");
        int isbn = leerNumero();
        Libro libro = libroServicio.buscarLibro(isbn);
        
        System.out.println("ISBN: " + libro.getIsbn() + " " + libro.getTitulo() + " " + libro.getAutor());

    }

    public void mostrarLibrosPorTitulo(){
        System.out.println("Ingrese el titulo");
        String titulo = leerCadena();
        
        List<Libro> libros = libroServicio.buscarLibrosPorTitulo(titulo);
        imprimirLibros(libros);
    }
    
    public void imprimirLibros(List<Libro> libros){
        for(Libro libro : libros){
            System.out.println("ISBN: " + libro.getIsbn() + " " + libro.getTitulo() + " " + libro.getAutor());
        }
    }
    
    public void prestamo(){
        System.out.println("Ingrese la fecha de hoy(ejemplo 2020-08-01)");
        String fecha = leerCadena();
        System.out.println("Ingrese fecha de devolucion");
        String devolucion = leerCadena();
        
        boolean control = true;
        List<Integer> id_libros = new ArrayList();
        while(control == true){
            System.out.println("Ingrese id de libro");
            int id = leerNumero();
            id_libros.add(id);
            System.out.println("Quiere otro libro Si/No");
            String respuesta = leerCadena();
            if ("No".equals(respuesta))
                control = false;
        }
        
        System.out.println("Ingrese el documento del cliente");
        int doc = leerNumero();
        
        prestamoServicio.guardar(fecha, devolucion, id_libros, doc);
        
        
    }
    
    public void devolucion(){
        System.out.println("Ingrese id del prestamo");
        String id_prestamo = leerCadena();
        System.out.println("Ingrese id del libro");
        int id_libro = leerNumero();
        
        Prestamo prestamo = prestamoServicio.buscarPorId(id_prestamo);
        List<Libro> libros = prestamo.getLibros();
        for(Libro l: libros){
            if (l.getIsbn() == id_libro){
                l.setEjemplares(l.getEjemplares()+1);
                l.setPrestados(l.getPrestados()-1);
                libros.remove(l);
                break;
            }
            
        }
        
        
    }
    
    public void crearCliente(){
        System.out.println("Ingrese documento");
        int documento = leerNumero();
        System.out.println("Ingrese nombre");
        String nombre = leerCadena();
        System.out.println("Ingrese apellido");
        String apellido = leerCadena();
        System.out.println("Ingrese domicilio");
        String domicilio = leerCadena();
        System.out.println("Ingrese telefono");
        String telefono = leerCadena();
        
        clienteServicio.guardar(documento, nombre, apellido, domicilio, telefono);
        
    }
    
    public void agregarLibrosPrestamo(){
        
        System.out.println("Ingrese id del prestamo");
        String id = leerCadena();
        
        Prestamo prestamo = prestamoServicio.buscarPorId(id);
        
        boolean control = true;
        List<Integer> id_libros = new ArrayList();
        while(control = true){
            System.out.println("Ingrese id de libro");
            int id_l = leerNumero();
            Libro libro = libroServicio.buscarLibro(id_l);
            prestamo.getLibros().add(libro);
            
            System.out.println("Quiere otro libro Si/No");
            String respuesta = leerCadena();
            if (respuesta == "No")
                control = false;
        }
        
        
    }
    
}
