package libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
    
    @Id
    private Integer isbn;
    private String titulo;
    private Integer anio; 
    private Integer prestados;
    private Integer ejemplares;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne
    private Editorial editorial; 
    
    
    
    public Integer getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getPrestados() {
        return prestados;
    }

    public void setPrestados(Integer prestados) {
        this.prestados = prestados;
    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the editorial
     */
    public Editorial getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    
    
}
