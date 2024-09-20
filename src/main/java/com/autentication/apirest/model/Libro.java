package com.autentication.apirest.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="Libro")
@Table(name = "LIBROS")
@Data
public class Libro {
    @Id
    @SequenceGenerator(
            name="libro_sequence",
            sequenceName = "libro_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "libro_sequence")
    private Long id;

    @Column
    private String titulo;
    @Column
    private Date fechapublicacion;

    // many to one, necesitamos instancia de ese ONE
    @ManyToOne
    private Author autor;

    public Libro(Long id, String titulo, Date fechaPublicacion, Author autor) {
        this.id = id;
        this.titulo = titulo;
        this.fechapublicacion = fechaPublicacion;
        this.autor = autor;
    }

    public Libro(Libro libro) {
        this(libro.getId(), libro.getTitulo(), libro.getFechapublicacion(), libro.getAutor());
    }

    public Libro() {

    }
    public Libro(String titulo, Date fecha, Author aut){
        this.titulo = titulo;
        fechapublicacion =fecha;
        autor=aut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechaPublicacion) {
        this.fechapublicacion = fechaPublicacion;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }
}
