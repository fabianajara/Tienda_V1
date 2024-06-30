package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

//especificar que es una capa de datos
@Data
//esta clase esa enlazada a una tabla en la bdd
@Entity
//especificar cual entidad
@Table(name = "categoria")

public class Categoria implements Serializable {

    //auto-increment java
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String categoria, boolean activo) {
        this.descripcion = categoria;
        this.activo = activo;
    }

}
