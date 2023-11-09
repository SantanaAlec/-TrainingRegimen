// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package com.itson.dominio;

import java.time.LocalDate;
import java.util.List;

public class Regimen {

    private Integer id;
    private Usuario entrenador;
    private Usuario metodologo;
    private Usuario jefeRama;
    private String Rama;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String deporte;
    private List<Etapa> etapas;
    private List<Medio> medios;

    public Regimen() {
    }

    public Regimen(Integer id, Usuario entrenador, Usuario metodologo, String deporte, List<Etapa> etapas, List<Medio> medios) {
        this.id = id;
        this.entrenador = entrenador;
        this.metodologo = metodologo;
        this.deporte = deporte;
        this.etapas = etapas;
        this.medios = medios;
    }

    public Regimen(Integer id, Usuario entrenador, Usuario metodologo, LocalDate fechaInicio, LocalDate fechaFinal, String deporte, List<Etapa> etapas, List<Medio> medios) {
        this.id = id;
        this.entrenador = entrenador;
        this.metodologo = metodologo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
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

    public Usuario getJefeRama() {
        return jefeRama;
    }

    public void setJefeRama(Usuario jefeRama) {
        this.jefeRama = jefeRama;
    }

    public String getRama() {
        return Rama;
    }

    public void setRama(String Rama) {
        this.Rama = Rama;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    

    @Override
    public String toString() {
        return "Regimen{" + "id=" + id + ", entrenador=" + entrenador + ", metodologo=" + metodologo + ", deporte=" + deporte + ", etapas=" + etapas + ", medios=" + medios + '}';
    }

}
