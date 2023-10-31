/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import com.itson.dominio.Estado;
import implementaciones.RegimenEstadoDAO;
import interfaces.IRegimenEstadoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.itson.dominio.RegimenEstado;
import com.itson.dominio.TipoUsuario;
import com.itson.dominio.Usuario;
import implementaciones.ConexionBD;
import implementaciones.UsuariosDAO;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;

/**
 *
 * @author Andrea
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PRegimenes");
        EntityManager em = emFactory.createEntityManager();
        
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenEstadoDAO = new RegimenEstadoDAO(conexion);
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        
        em.getTransaction().begin();
         
         //PROBANDO DAO USUARIOS
//         Usuario usuario= new Usuario("Sandra Lopez", "4321", TipoUsuario.ENTRENADOR);
//         usuariosDAO.agregar(usuario);
//         System.out.println(usuariosDAO.consultar(1));
//         System.out.println(usuariosDAO.consultarTodos().toString());
//         System.out.println(usuariosDAO.consultar("Jose Lopez"));
//         usuariosDAO.actualizar(new Usuario(1,"Jose Lopez","0000",TipoUsuario.ENTRENADOR)); //no funciona 
           
   
         //PROBANDO DAO REGIMENES ESTADOS
//         Usuario usuarioTest = new Usuario();
//         usuarioTest.setId(2);
//         RegimenEstado estado = new RegimenEstado("regimen voleybol",usuarioTest, Estado.NO_APROBADO);
//         regimenEstadoDAO.agregar(estado);
//         System.out.println(regimenEstadoDAO.consultar(2));
//         System.out.println(regimenEstadoDAO.consultarTodos().toString());
        
    }
    
}
