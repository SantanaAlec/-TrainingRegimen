/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.dominio;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author Andrea
 */
@Entity
@Table(name="regimenes_estados")
public class RegimenEstado {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable=false)
    private String nombre;
    
    @Column(name = "entrenador_id", nullable=false)
    private Integer entrenador_id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable=false)
    private Estado estado;

    public RegimenEstado() {
    }

    public RegimenEstado(String nombre, Integer entrenador_id, Estado estado) {
        this.nombre = nombre;
        this.entrenador_id = entrenador_id;
        this.estado = estado;
    }

    
    public RegimenEstado(int id, String nombre, int entrenador_id, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador_id = entrenador_id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEntrenador_id() {
        return entrenador_id;
    }

    public void setEntrenador_id(int entrenador_id) {
        this.entrenador_id = entrenador_id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegimenEstado other = (RegimenEstado) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.entrenador_id == other.entrenador_id;
    }
    
    
}
