// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package com.itson.dominio;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "regimenes_estados")
public class RegimenEstado {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToOne
    //@Column(name = "entrenador_id", nullable=false)
    private Usuario entrenador;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    public RegimenEstado() {
    }

    public RegimenEstado(String nombre, Usuario entrenador, Estado estado) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.estado = estado;
    }

    public RegimenEstado(int id, String nombre, Usuario entrenador, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador = entrenador;
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

    public Usuario getEntrenador_id() {
        return entrenador;
    }

    public void setEntrenador(Usuario entrenador) {
        this.entrenador = entrenador;
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
        return this.entrenador == other.entrenador;
    }

    @Override
    public String toString() {
        return "RegimenEstado{" + "id=" + id + ", nombre=" + nombre + ", entrenador=" + entrenador + ", estado=" + estado + '}';
    }

}
