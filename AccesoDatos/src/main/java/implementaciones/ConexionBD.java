/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andrea
 */
public class ConexionBD implements IConexionBD{

    @Override
    public EntityManager crearConexion() throws IllegalThreadStateException {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PRegimenes");
        EntityManager em = emFactory.createEntityManager();
        return em;
    }
    
}