// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package implementaciones;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionBD implements IConexionBD{
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PRegimenes");
    @Override
    public EntityManager crearConexion() throws IllegalThreadStateException {
    
        EntityManager em = emFactory.createEntityManager();
        return em;
    }
    
}