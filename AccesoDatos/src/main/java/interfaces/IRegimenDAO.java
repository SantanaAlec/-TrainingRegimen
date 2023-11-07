// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package interfaces;

import com.itson.dominio.Regimen;

public interface IRegimenDAO {
    public void guardar(Regimen regimen);
    public Regimen consultar();
}
