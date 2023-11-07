// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package com.itson.dominio;

import java.util.List;

public class Regimen {

    private Integer id;
    private Usuario entrenador;
    private Usuario metodologo;
    private String deporte;
    private List<Etapa> etapas;
    private List<Medio> medios;

    public Regimen(Integer id, Usuario entrenador, Usuario metodologo, String deporte, List<Etapa> etapas, List<Medio> medios) {
        this.id = id;
        this.entrenador = entrenador;
        this.metodologo = metodologo;
        this.deporte = deporte;
        this.etapas = etapas;
        this.medios = medios;
    }

    public Regimen(Usuario entrenador, Usuario metodologo, String deporte, List<Etapa> etapas, List<Medio> medios) {
        this.entrenador = entrenador;
        this.metodologo = metodologo;
        this.deporte = deporte;
        this.etapas = etapas;
        this.medios = medios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Usuario entrenador) {
        this.entrenador = entrenador;
    }

    public Usuario getMetodologo() {
        return metodologo;
    }

    public void setMetodologo(Usuario metodologo) {
        this.metodologo = metodologo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public List<Medio> getMedios() {
        return medios;
    }

    public void setMedios(List<Medio> medios) {
        this.medios = medios;
    }

    @Override
    public String toString() {
        return "Regimen{" + "id=" + id + ", entrenador=" + entrenador + ", metodologo=" + metodologo + ", deporte=" + deporte + ", etapas=" + etapas + ", medios=" + medios + '}';
    }

}
