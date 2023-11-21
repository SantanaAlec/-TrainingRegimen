/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import com.itson.dominio.Estado;
import com.itson.dominio.RegimenEstado;
import com.itson.dominio.TipoUsuario;
import com.itson.dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.IRegimenDAO;
import interfaces.IRegimenEstadoDAO;
import interfaces.IUsuariosDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andrea
 */
public class RegimenEstadoDAOTest {
    
    public RegimenEstadoDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of agregar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testAgregar() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenDAO = new RegimenEstadoDAO(conexion);
        IUsuariosDAO usuarioDAO = new UsuariosDAO(conexion);
        usuarioDAO.agregar( new Usuario("Prueba agregar", "4321", TipoUsuario.ENTRENADOR));
        
        System.out.println("agregar regimen estado");
        RegimenEstado regimen = new RegimenEstado("Prueba agregar", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        assertDoesNotThrow(() -> {
            regimenDAO.agregar(regimen);
        });

        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("Prueba agregar"));
        try {
            regimenDAO.eliminarPorNombres(usuarioPrueba);
            usuarioDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of eliminar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenDAO = new RegimenEstadoDAO(conexion);
        IUsuariosDAO usuarioDAO = new UsuariosDAO(conexion);
        usuarioDAO.agregar( new Usuario("Prueba eliminar", "4321", TipoUsuario.ENTRENADOR));
        
        System.out.println("eliminar regimen estado");
        RegimenEstado regimen = new RegimenEstado("Prueba eliminar", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        regimenDAO.agregar(regimen);
        assertDoesNotThrow(() -> {
            regimenDAO.eliminar(regimenDAO.consultarPorNombre("Prueba eliminar").getId());
        });

        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("Prueba eliminar"));
        try {
            regimenDAO.eliminarPorNombres(usuarioPrueba);
            usuarioDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of actualizar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testActualizar() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenDAO = new RegimenEstadoDAO(conexion);
        IUsuariosDAO usuarioDAO = new UsuariosDAO(conexion);
        usuarioDAO.agregar( new Usuario("Prueba actualizar", "4321", TipoUsuario.ENTRENADOR));
        
        System.out.println("actualizar regimen estado");
        RegimenEstado regimen = new RegimenEstado("Prueba actualizar", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        regimenDAO.agregar(regimen);
        regimen.setNombre("Prueba actualizar");
        assertDoesNotThrow(() -> {
            regimenDAO.actualizar(regimen);
        });
        
        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("Prueba actualizar"));
        try {
            regimenDAO.eliminarPorNombres(usuarioPrueba);
            usuarioDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    @Test
    public void testConsultar_Inexistente() {
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenDAO = new RegimenEstadoDAO(conexion);
        System.out.println("consultar regimen inexistente");
        Integer idUsuario = -1;

        assertThrows(Exception.class, () -> {
            regimenDAO.consultar(idUsuario);
        });
        

    }

    /**
     * Test of consultar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testConsultar() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenDAO = new RegimenEstadoDAO(conexion);
        IUsuariosDAO usuarioDAO = new UsuariosDAO(conexion);
        usuarioDAO.agregar( new Usuario("Prueba consultar", "4321", TipoUsuario.ENTRENADOR));
        
        System.out.println("consutlar regimen estado");
        RegimenEstado regimen = new RegimenEstado("Prueba consultar", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        assertDoesNotThrow(() -> {
            regimenDAO.agregar(regimen);
        });
        
        assertDoesNotThrow(() -> {
            regimenDAO.consultar(regimenDAO.consultarPorNombre("Prueba consultar").getId());
        });

        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("Prueba consultar"));
        try {
            regimenDAO.eliminarPorNombres(usuarioPrueba);
            usuarioDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of consultarTodos method, of class RegimenEstadoDAO.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenDAO = new RegimenEstadoDAO(conexion);
        IUsuariosDAO usuarioDAO = new UsuariosDAO(conexion);
        usuarioDAO.agregar( new Usuario("consutlar estados de regimenes", "4321", TipoUsuario.ENTRENADOR));
        
        System.out.println("consutlar estados de regimenes");
        RegimenEstado regimen = new RegimenEstado("consutlar estados de regimenes", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        regimenDAO.agregar(regimen);
        
        assertDoesNotThrow(() -> {
            regimenDAO.consultarTodos();
        });
        
        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("consutlar estados de regimenes"));
        try {
            regimenDAO.eliminarPorNombres(usuarioPrueba);
            usuarioDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of consultarPorEntrenador method, of class RegimenEstadoDAO.
     */
    @Test
    public void testConsultarPorEntrenador() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IRegimenEstadoDAO regimenDAO = new RegimenEstadoDAO(conexion);
        IUsuariosDAO usuarioDAO = new UsuariosDAO(conexion);
        usuarioDAO.agregar( new Usuario("consutlar estados de regimenes", "4321", TipoUsuario.ENTRENADOR));
        
        System.out.println("consutlar estados de regimenes");
        RegimenEstado regimen = new RegimenEstado("consutlar estados de regimenes",
                usuarioDAO.consultar("consutlar estados de regimenes"), Estado.NO_APROBADO);
        regimenDAO.agregar(regimen);
        
        assertDoesNotThrow(() -> {
            regimenDAO.consultarPorEntrenador(usuarioDAO.consultar("consutlar estados de regimenes").getId());
        });
        
        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("consutlar estados de regimenes"));
        try {
            regimenDAO.eliminarPorNombres(usuarioPrueba);
            usuarioDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
