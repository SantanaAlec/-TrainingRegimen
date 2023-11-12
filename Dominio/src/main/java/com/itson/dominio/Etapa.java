// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package com.itson.dominio;

import java.util.ArrayList;
import java.util.List;

public class Etapa {

    String nombre;
    int totalSemanas;
    List<Mesociclo> mesociclos;

    
    public Etapa(String nombre, int totalSemanas, List<Mesociclo> mesociclos) {
        this.nombre = nombre;
        this.totalSemanas = totalSemanas;
        this.mesociclos = mesociclos;
        mesociclos= new ArrayList<>();
    }
    
    public Etapa(String nombre, int totalSemanas) {
        this.nombre = nombre;
        this.totalSemanas = totalSemanas;
        mesociclos= new ArrayList<>();
    }
    
    public Etapa(String nombre) {
        this.nombre = nombre;
        mesociclos= new ArrayList<>();
    }

    public Etapa() {
        mesociclos= new ArrayList<>();
    }

    public Etapa(int totalSemanas) {
        this.totalSemanas = totalSemanas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalSemanas() {
        return totalSemanas;
    }

    public void setTotalSemanas(int totalSemanas) {
        this.totalSemanas = totalSemanas;
    }

    public List<Mesociclo> getMesociclos() {
        return mesociclos;
    }

    public void setMesociclos(List<Mesociclo> mesociclos) {
        this.mesociclos = mesociclos;
    }

    public void addMesociclo(Mesociclo mesociclo){
        mesociclos.add(mesociclo);
    }
    
    public void removeMesociclo(Mesociclo mesociclo){
        mesociclos.remove(mesociclo);
    }

    @Override
    public String toString() {
        return "Etapa{" + "nombre=" + nombre + ", totalSemanas=" + totalSemanas + '}';
    }

}
