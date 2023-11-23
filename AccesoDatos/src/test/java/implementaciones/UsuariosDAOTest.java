// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package implementaciones;

import com.itson.dominio.Estado;
import com.itson.dominio.RegimenEstado;
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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UsuariosDAOTest {

    @Mock
    IConexionBD conexion;
    @Mock
    IUsuariosDAO usuarioDAO;
    
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
        System.out.println("Testing agregar...");
        MockitoAnnotations.openMocks(this);
        Usuario usuarioTest = new Usuario("Prueba agregar", "4321", TipoUsuario.ENTRENADOR);

        assertDoesNotThrow(() -> {
            usuarioDAO.agregar(usuarioTest);
        });
    }

    @Test
    public void testAgregarNull() throws Exception {
        System.out.println("Testing agregar null...");
        MockitoAnnotations.openMocks(this);
        
        Mockito.doThrow(NullPointerException.class).when(usuarioDAO).agregar(null);

        assertThrows(NullPointerException.class, () -> {
            usuarioDAO.agregar(null);
        });

    }

    /**
     * Test of actualizar method, of class UsuariosDAO.
     */
    @Test
    public void testActualizar() throws Exception {
        System.out.println("Testing actualizar...");
        MockitoAnnotations.openMocks(this);
        Usuario usuarioTest = new Usuario("Prueba actualizar", "4321", TipoUsuario.ENTRENADOR);

        assertDoesNotThrow(() -> {
            usuarioDAO.actualizar(usuarioTest);
        });
    }

    /**
     * Test of actualizar method, of class UsuariosDAO.
     */
    @Test
    public void testActualizarNull() throws Exception {
        System.out.println("Testing actualizar null...");
        MockitoAnnotations.openMocks(this);
        Usuario usuarioTest = new Usuario("Prueba actualizar", "4321", TipoUsuario.ENTRENADOR);

        Mockito.doThrow(Exception.class).when(usuarioDAO).agregar(null);

        assertThrows(Exception.class, () -> {
            usuarioDAO.agregar(null);
        });
    }
    
    /**
     * Test of consultar method, of class UsuariosDAO.
     */
    @Test
    public void testConsultar_IusuarioExistente() throws Exception {
       
        System.out.println("Testing consultar...");
        MockitoAnnotations.openMocks(this);
        Usuario usuarioTest = new Usuario("Prueba agregar", "4321", TipoUsuario.ENTRENADOR);
        Mockito.when(usuarioDAO.consultar(1)).thenReturn(usuarioTest);
        
        assertEquals(usuarioTest, usuarioDAO.consultar(1));

    }

    /**
     * Test of consultar method, of class UsuariosDAO.
     */
    @Test
    public void testConsultar_usuarioInexistente() throws Exception {
        System.out.println("Testing consultar inexistente...");
        MockitoAnnotations.openMocks(this);

        Mockito.doThrow(Exception.class).when(usuarioDAO).consultar(-1);

        assertThrows(Exception.class, () -> {
            usuarioDAO.consultar(-1);
        });
    }

    /**
     * Test of consultarTodos method, of class UsuariosDAO.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        System.out.println("Testing consultar todos...");
        MockitoAnnotations.openMocks(this);

        Usuario usuarioTest = new Usuario("Prueba consultar todos", "4321", TipoUsuario.ENTRENADOR);
       
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioTest);
        
        Mockito.when(usuarioDAO.consultarTodos()).thenReturn(usuarios);
        
        assertEquals(usuarios, usuarioDAO.consultarTodos());
    }

    /**
     * Test of consultar method, of class UsuariosDAO.
     */
    @Test
    public void testConsultar_String() throws Exception {
        System.out.println("Testing consultar todos...");
        MockitoAnnotations.openMocks(this);

        Usuario usuarioTest = new Usuario("Prueba", "4321", TipoUsuario.ENTRENADOR);
       
        Mockito.when(usuarioDAO.consultar("Prueba")).thenReturn(usuarioTest);
        
        assertEquals(usuarioTest, usuarioDAO.consultar("Prueba"));

    }

    /**
     * Test of consultarEntrenadores method, of class UsuariosDAO.
     */
    @Test
    public void testConsultarEntrenadores() throws Exception {
        System.out.println("Testing consultar entrenadores...");
        MockitoAnnotations.openMocks(this);

        Usuario usuarioTest = new Usuario("Prueba consultar esntrenadores", "4321", TipoUsuario.ENTRENADOR);
       
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioTest);
        
        Mockito.when(usuarioDAO.consultarEntrenadores()).thenReturn(usuarios);
        
        assertEquals(usuarios, usuarioDAO.consultarEntrenadores());
    }

    /**
     * Test of eliminar method, of class UsuariosDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("Testing eliminar...");
        MockitoAnnotations.openMocks(this);

        assertDoesNotThrow(() -> {
            usuarioDAO.eliminar(Mockito.anyInt());
        });
    }

    /**
     * Test of eliminar method, of class UsuariosDAO.
     */
    @Test
    public void testEliminarInexistente() throws Exception {
        System.out.println("Testing eliminar inexistente...");
        MockitoAnnotations.openMocks(this);

        Mockito.doThrow(Exception.class).when(usuarioDAO).eliminar(-1);

        assertThrows(Exception.class, () -> {
            usuarioDAO.eliminar(-1);
        });
    }
}
