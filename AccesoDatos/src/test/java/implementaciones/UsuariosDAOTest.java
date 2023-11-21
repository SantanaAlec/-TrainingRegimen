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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeList;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuariosDAOTest {

    public UsuariosDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
     
    }

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregar method, of class UsuariosDAO.
     */
    @Test
    public void testAgregar() {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        System.out.println("agregar");
        Usuario usuario = new Usuario("Prueba agregar", "4321", TipoUsuario.ENTRENADOR);
        assertDoesNotThrow(() -> {
            usuariosDAO.agregar(usuario);
        });

        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("Prueba agregar"));
        try {
            usuariosDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testAgregarNull() {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        System.out.println("agregar");
        Usuario usuario = null;
        assertThrows(NullPointerException.class, () -> {
            usuariosDAO.agregar(usuario);
        });

    }

    /**
     * Test of actualizar method, of class UsuariosDAO.
     */
    @Test
    public void testActualizar() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        Usuario usuarioTest = new Usuario("Prueba actualizar", "4321", TipoUsuario.ENTRENADOR);
        usuariosDAO.agregar(usuarioTest);
        System.out.println("actualizar");
        Usuario usuario = usuariosDAO.consultar("Prueba actualizar");
        usuario.setNombre("Prueba-unitaria");

        assertDoesNotThrow(() -> {
            usuariosDAO.actualizar(usuario);
        });

        assertDoesNotThrow(() -> {
            usuariosDAO.consultar("Prueba-unitaria");
        });

        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("Prueba-unitaria"));
        try {
            usuariosDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of consultar method, of class UsuariosDAO.
     */
    @Test
    public void testConsultar_IusuarioExistente() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        Usuario usuarioTest = new Usuario("Prueba consultar id", "4321", TipoUsuario.ENTRENADOR);
        usuariosDAO.agregar(usuarioTest);
        System.out.println("consultar");
        Integer idUsuario = 1;

        assertDoesNotThrow(() -> {
            usuariosDAO.consultar(idUsuario);
        },
                "El usuario que quiere consultar, no existe");

        ArrayList usuarioPrueba = new ArrayList(Arrays.asList("Prueba consultar id"));
        try {
            usuariosDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of consultar method, of class UsuariosDAO.
     */
    @Test
    public void testConsultar_usuarioInexistente() {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        System.out.println("consultar");
        Integer idUsuario = -1;

        assertThrows(Exception.class, () -> {
            usuariosDAO.consultar(idUsuario);
        });
        

    }

    /**
     * Test of consultarTodos method, of class UsuariosDAO.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);

        Usuario usuarioTest = new Usuario("Prueba consultar todos", "4321", TipoUsuario.ENTRENADOR);
        usuariosDAO.agregar(usuarioTest);
        System.out.println("consultarTodos");
        List<Usuario> result = usuariosDAO.consultarTodos();
        assertTrue(!result.isEmpty());
        
        ArrayList usuarioPrueba= new ArrayList(Arrays.asList("Prueba consultar todos"));
        try {
            usuariosDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of consultar method, of class UsuariosDAO.
     */
    @Test
    public void testConsultar_String() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);

        Usuario usuarioTest = new Usuario("Prueba consultar nombre", "4321", TipoUsuario.ENTRENADOR);
        usuariosDAO.agregar(usuarioTest);
        System.out.println("consultar");
        String nombre = "Prueba consultar nombre";

        Usuario result = usuariosDAO.consultar(nombre);
        assertEquals(nombre, result.getNombre());
        
        ArrayList usuarioPrueba= new ArrayList(Arrays.asList("Prueba consultar nombre"));
        try {
            usuariosDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of consultarEntrenadores method, of class UsuariosDAO.
     */
    @Test
    public void testConsultarEntrenadores() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);

        Usuario usuarioTest = new Usuario("Prueba consultar entrenadores", "4321", TipoUsuario.ENTRENADOR);
        usuariosDAO.agregar(usuarioTest);
        System.out.println("consultar Entrenadores");
        List<Usuario> result = usuariosDAO.consultarTodos();
        assertTrue(!result.isEmpty());
        
        ArrayList usuarioPrueba= new ArrayList(Arrays.asList("Prueba consultar entrenadores"));
        try {
            usuariosDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of eliminar method, of class UsuariosDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        IConexionBD conexion = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        Usuario usuarioTest = new Usuario("Prueba eliminar", "4321", TipoUsuario.ENTRENADOR);
        usuariosDAO.agregar(usuarioTest);

        System.out.println("eliminar");
        Integer idUsuario = usuariosDAO.consultar("Prueba eliminar").getId();

        assertDoesNotThrow(() -> {
            usuariosDAO.eliminar(idUsuario);
        });
        
        ArrayList usuarioPrueba= new ArrayList(Arrays.asList("Prueba eliminar"));
        try {
            usuariosDAO.eliminarPorNombres(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
