// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package com.itson.dominio;

import java.util.Objects;

public class Mesociclo {

    int noMesociclo;
    Etapa etapa;
    int noSemanas;

    public Mesociclo(int noMesociclo, Etapa etapa, int noSemanas) {
        this.noMesociclo = noMesociclo;
        this.etapa = etapa;
        this.noSemanas = noSemanas;
    }

    public Mesociclo(int noMesociclo, Etapa etapa) {
        this.noMesociclo = noMesociclo;
        this.etapa = etapa;
    }
    
    public Mesociclo(Etapa etapa, int noSemanas) {
        this.etapa = etapa;
        this.noSemanas = noSemanas;
    }

    public Mesociclo() {
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public int getNoSemanas() {
        return noSemanas;
    }

    public void setNoSemanas(int noSemanas) {
        this.noSemanas = noSemanas;
    }

    public int getNoMesociclo() {
        return noMesociclo;
    }

    public void setNoMesociclo(int noMesociclo) {
        this.noMesociclo = noMesociclo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.noMesociclo;
        hash = 59 * hash + Objects.hashCode(this.etapa);
        hash = 59 * hash + this.noSemanas;
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
        final Mesociclo other = (Mesociclo) obj;
        if (this.noMesociclo != other.noMesociclo) {
            return false;
        }
        if (this.noSemanas != other.noSemanas) {
            return false;
        }
        return Objects.equals(this.etapa, other.etapa);
    }

    @Override
    public String toString() {
        return "Mesociclo{" + "noMesociclo=" + noMesociclo + ", etapa=" + etapa + ", noSemanas=" + noSemanas + '}';
    }

}
