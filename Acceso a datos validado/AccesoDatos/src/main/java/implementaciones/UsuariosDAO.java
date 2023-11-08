/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.itson.dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andrea
 */
public class UsuariosDAO implements IUsuariosDAO {

    private final IConexionBD conexionBD;

    public UsuariosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregar(Usuario usuario)throws Exception {
        EntityManager em = this.conexionBD.crearConexion();
        try {
     //Si se quiere agregar un usuario que ya existe
     Usuario usuarioEncontrado = em.find(Usuario.class, usuario);
       if(usuarioEncontrado!=null){
           throw new Exception("El usuario que quiere agregar ya existe");
       }
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Override
    public void eliminar(Integer idUsuario)throws Exception {

        EntityManager em = this.conexionBD.crearConexion();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, idUsuario);
         // Entrenador entrenador = em.find(Entrenador.class, idUsuario);
         /*
         if(entrenador!=null){
         throw new Exception ("")
         }
         */
            //si el usuario le pertenece a un usuario
            
            if (usuario != null) {
                em.remove(usuario);
            }else{
                throw new Exception("Se quiere eliminaar un usuario que no existe");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Override
    public void actualizar(Usuario usuario)throws Exception {
        EntityManager em = this.conexionBD.crearConexion();

        try {
            if (usuario != null) {
                em.getTransaction().begin();
                Usuario usuarioEncontrado = em.find(Usuario.class, usuario.getId());

                if (usuarioEncontrado != null) {
                    em.merge(usuario);
                }else{
                    throw new Exception("El usuario que quiere actualizar, no existe");
                }
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public Usuario consultar(Integer idUsuario) throws Exception{

        EntityManager em = this.conexionBD.crearConexion();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, idUsuario);
            em.getTransaction().commit();
            if(usuario==null){
                throw new Exception ("El usuario que quiere consultar, no existe");
            }
            return usuario;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Usuario> consultarTodos() throws Exception{

        EntityManager em = this.conexionBD.crearConexion();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            em.getTransaction().commit();

            return query.getResultList();
        } finally {
            em.close();
        }

    }

    @Override
    public Usuario consultar(String nombre)throws Exception {
        EntityManager em = this.conexionBD.crearConexion();

        try {
            em.getTransaction().begin();
            String jpql = "SELECT u FROM Usuario u WHERE u.nombre = :nombre";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("nombre", nombre);
            em.getTransaction().commit();
            List<Usuario> usuarios = query.getResultList();
            if (usuarios.isEmpty()) {
                throw new Exception ("No existe el usuario con el nombre que diste");
            }
            return (Usuario) query.getResultList().get(0);
        } finally {
            em.close();
        }

    }

}
