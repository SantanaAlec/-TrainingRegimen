// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package implementaciones;

import com.itson.dominio.TipoUsuario;
import com.itson.dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class UsuariosDAO implements IUsuariosDAO {

    private final IConexionBD conexionBD;

    public UsuariosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregar(Usuario usuario) throws Exception {
        EntityManager em = this.conexionBD.crearConexion();
        try {
            //Si se quiere agregar un usuario que ya existe
//            Usuario usuarioEncontrado = em.find(Usuario.class, usuario.getId());
//            if (usuarioEncontrado != null) {
//                throw new Exception("El usuario que quiere agregar ya existe");
//            }
            if(usuario==null){
                throw new NullPointerException("El usuario que intenta agregar es null");
            }
           em.getTransaction().begin();
                em.persist(usuario);
                em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Override
    public void eliminar(Integer idUsuario) throws Exception {

        EntityManager em = this.conexionBD.crearConexion();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, idUsuario);
            if (usuario != null) {
                em.remove(usuario);
            } else {
                throw new Exception("Se quiere eliminar un usuario que no existe");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Override
    public void actualizar(Usuario usuario) throws Exception {
        EntityManager em = this.conexionBD.crearConexion();

        try {
            if (usuario != null) {
                em.getTransaction().begin();
                Usuario usuarioEncontrado = em.find(Usuario.class, usuario.getId());

                if (usuarioEncontrado != null) {
                    em.merge(usuario);
                } else {
                    throw new Exception("El usuario que quiere actualizar no existe");
                }
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public Usuario consultar(Integer idUsuario) throws Exception {

        EntityManager em = this.conexionBD.crearConexion();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, idUsuario);
            em.getTransaction().commit();
            if (usuario == null) {
                throw new Exception("El usuario que quiere consultar, no existe");
            }
            return usuario;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Usuario> consultarTodos() throws Exception {

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
    public Usuario consultar(String nombre) throws Exception {
        EntityManager em = this.conexionBD.crearConexion();

        try {
            em.getTransaction().begin();
            String jpql = "SELECT u FROM Usuario u WHERE u.nombre = :nombre";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("nombre", nombre);
            em.getTransaction().commit();
            List<Usuario> usuarios = query.getResultList();
            if (usuarios.isEmpty()) {
                throw new Exception("No existe el usuario con el nombre que diste");
            }
            return (Usuario) query.getResultList().get(0);
        } finally {
            em.close();
        }

    }
    
    @Override
    public List<Usuario> consultarEntrenadores()throws Exception {
        EntityManager em = this.conexionBD.crearConexion();
          
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.tipo = :tipo";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("tipo", TipoUsuario.ENTRENADOR);
            List<Usuario> usuarios = query.getResultList();

            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
   @Override
    public void eliminarPorNombres(ArrayList<String>nombres) throws Exception {

        EntityManager em = this.conexionBD.crearConexion();
              try {
            // Iniciar transacción si es necesario
            em.getTransaction().begin();

            // Construir la consulta para eliminar usuarios por nombres
            String queryString = "DELETE FROM Usuario u WHERE u.nombre IN :nombres";
            Query query = em.createQuery(queryString);
            query.setParameter("nombres", nombres);

            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            // Rollback en caso de excepción
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar usuarios", e);
        } finally {
           
            em.close();
        }

    }
    

}
