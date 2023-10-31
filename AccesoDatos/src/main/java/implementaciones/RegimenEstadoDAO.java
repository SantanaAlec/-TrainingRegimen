/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.itson.dominio.RegimenEstado;
import interfaces.IConexionBD;
import interfaces.IRegimenEstadoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andrea
 */
public class RegimenEstadoDAO implements IRegimenEstadoDAO{
 

     private final IConexionBD conexionBD;
    public RegimenEstadoDAO(IConexionBD conexionBD) {
        this.conexionBD=conexionBD;
    }
   
    @Override
    public void agregar(RegimenEstado regimenEstado) {
        
        EntityManager em =this.conexionBD.crearConexion();
        em.getTransaction().begin();
        if(regimenEstado!=null){
            em.persist(regimenEstado);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(RegimenEstado regimenEstado) {
        EntityManager em =this.conexionBD.crearConexion();
        em.getTransaction().begin();
          if(regimenEstado!=null){
            em.refresh(regimenEstado);
        }
          em.getTransaction().commit();
    }

    @Override
    public RegimenEstado consultar(Integer idRegimenEstado) {
        EntityManager em =this.conexionBD.crearConexion();
        em.getTransaction().begin();
        RegimenEstado estado = em.find(RegimenEstado.class, idRegimenEstado);
        em.getTransaction().commit();
        return estado;
    }

    @Override
    public List<RegimenEstado> consultarTodos() {
        EntityManager em =this.conexionBD.crearConexion();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT r FROM RegimenEstado r",RegimenEstado.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
    
}
