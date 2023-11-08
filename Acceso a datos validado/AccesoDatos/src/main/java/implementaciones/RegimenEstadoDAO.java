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
import javax.persistence.TypedQuery;

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
    public void agregar(RegimenEstado regimenEstado)throws Exception {
        
        EntityManager em =this.conexionBD.crearConexion();
        
        try{
        em.getTransaction().begin();
        if(regimenEstado!=null){
            em.persist(regimenEstado);
        }
        em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Ocurrio algun error");
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void eliminar(Integer idRegimenEstado)throws Exception {
        
        EntityManager em =this.conexionBD.crearConexion();
        
        try{
        em.getTransaction().begin();
        RegimenEstado rEncontrado = em.find(RegimenEstado.class, idRegimenEstado);

        if(rEncontrado!=null){
            em.remove(rEncontrado);
        }else{
            throw new Exception("El regimen que quiere eliminar no existe");
        }
        em.getTransaction().commit();
        }
        finally{
            em.close();
        }
    }
    

    @Override
    public void actualizar(RegimenEstado regimenEstado)throws Exception {
        EntityManager em =this.conexionBD.crearConexion();
        
        try{
        if (regimenEstado != null) {
                em.getTransaction().begin();
                RegimenEstado rEncontrado = em.find(RegimenEstado.class, regimenEstado.getId());
                if (rEncontrado != null) {
                    em.merge(regimenEstado);
                }else{
            throw new Exception("El regimen que quiere actualizar no existe");
                   }
                em.getTransaction().commit();
            }
        }
        finally{
            em.close();
        }
        
    }

    @Override
    public RegimenEstado consultar(Integer idRegimenEstado) throws Exception{
        EntityManager em =this.conexionBD.crearConexion();
        
        try{
        em.getTransaction().begin();
        RegimenEstado estado = em.find(RegimenEstado.class, idRegimenEstado);
        em.getTransaction().commit();
        if(estado==null){
        throw new Exception ("El regimen que quiere consultar no existe");
        }
        return estado;
        }
        
        finally{
            em.close();
        }
    }

    @Override
    public List<RegimenEstado> consultarTodos()throws Exception{
        EntityManager em =this.conexionBD.crearConexion();
        
        try{
              em.getTransaction().begin();
        Query query = em.createQuery("SELECT r FROM RegimenEstado r",RegimenEstado.class);
        em.getTransaction().commit();
        return query.getResultList();
        }
        finally{
            em.close();
        }
        
    }

    @Override
    public RegimenEstado consultarPorEntrenador(Integer idEntrenador) throws Exception{

        EntityManager em =this.conexionBD.crearConexion();
        
        try {
            em.getTransaction().begin();
            String jpql = "SELECT re FROM RegimenEstado re WHERE re.entrenador.id = :entrenadorId";
            TypedQuery<RegimenEstado> query = em.createQuery(jpql, RegimenEstado.class);
            query.setParameter("entrenadorId", idEntrenador);
            em.getTransaction().commit();
            List<RegimenEstado> usuarios = query.getResultList();
            if (usuarios.isEmpty()) {
                throw new Exception("Ocurrio algun error al consultar por entrenador");
            }
            return (RegimenEstado) query.getResultList().get(0);
        } finally {
            em.close();
        }
    }
    
}
