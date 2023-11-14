/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.List;

/**
 *
 * @author Andrea
 */
public class Medio {
    
    private String medio;
    private String medicion;
    private double volumenTotal;
    private List<Etapa> etapas;
    
    public Medio(String medio, String medicion, double volumenTotal) {
        this.medio = medio;
        this.medicion = medicion;
        this.volumenTotal = volumenTotal;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getMedicion() {
        return medicion;
    }

    public void setMedicion(String medicion) {
        this.medicion = medicion;
    }

    public double getVolumenTotal() {
        return volumenTotal;
    }

    public void setVolumenTotal(double volumenTotal) {
        this.volumenTotal = volumenTotal;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    
    @Override
    public String toString() {
        return "Medio{" + "medio=" + medio + ", medicion=" + medicion + ", volumenTotal=" + volumenTotal + '}';
    }

}
