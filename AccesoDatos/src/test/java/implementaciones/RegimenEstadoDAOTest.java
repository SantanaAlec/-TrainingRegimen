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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RegimenEstadoDAOTest {

    @Mock
    IConexionBD conexion;
    @Mock
    IUsuariosDAO usuarioDAO;

    @Mock
    IRegimenEstadoDAO regimenestadoDAO;

    public RegimenEstadoDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setup() {

    }

    /**
     * Test of agregar method, of class RegimenEstadoDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAgregar() throws Exception {
        System.out.println("Testing agregar...");
        MockitoAnnotations.openMocks(this);
        Mockito.when(usuarioDAO.consultar(1)).thenReturn(new Usuario("Prueba agregar", "4321", TipoUsuario.ENTRENADOR));
        RegimenEstado regimenEstado = new RegimenEstado("Prueba agregar", usuarioDAO.consultar(1), Estado.NO_APROBADO);

        assertDoesNotThrow(() -> {
            regimenestadoDAO.agregar(regimenEstado);
        });

    }

    @Test
    public void testAgregarNull() throws Exception {
        System.out.println("Testing agregar null...");
        MockitoAnnotations.openMocks(this);

        Mockito.doThrow(Exception.class).when(regimenestadoDAO).agregar(null);
        assertThrows(Exception.class, () -> {
            regimenestadoDAO.agregar(null);
        });

    }

    /**
     * Test of eliminar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("Testing eliminar...");
        MockitoAnnotations.openMocks(this);

        assertDoesNotThrow(() -> {
            regimenestadoDAO.eliminar(Mockito.anyInt());
        });

    }

    /**
     * Test of eliminar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testEliminarInexistente() throws Exception {
        System.out.println("Testing eliminar inexistente...");
        MockitoAnnotations.openMocks(this);

        Mockito.doThrow(Exception.class).when(regimenestadoDAO).eliminar(-1);

        assertThrows(Exception.class, () -> {
            regimenestadoDAO.eliminar(-1);
        });

    }

    /**
     * Test of actualizar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testActualizar() throws Exception {
        System.out.println("Testing actualizar...");
        MockitoAnnotations.openMocks(this);
        Mockito.when(usuarioDAO.consultar(1)).thenReturn(new Usuario("Prueba agregar", "4321", TipoUsuario.ENTRENADOR));
        RegimenEstado regimenEstado = new RegimenEstado("Prueba agregar", usuarioDAO.consultar(1), Estado.NO_APROBADO);

        assertDoesNotThrow(() -> {
            regimenestadoDAO.actualizar(regimenEstado);
        });

    }

    @Test
    public void testActualizarInexistente() throws Exception {
        System.out.println("Testing actualizar inexistente...");
        MockitoAnnotations.openMocks(this);
        Mockito.when(usuarioDAO.consultar(1)).thenReturn(new Usuario("Prueba agregar", "4321", TipoUsuario.ENTRENADOR));

        RegimenEstado regimenEstado = new RegimenEstado("Prueba agregar", new Usuario(), Estado.NO_APROBADO);

        Mockito.doThrow(Exception.class).when(regimenestadoDAO).actualizar(regimenEstado);

        assertThrows(Exception.class, () -> {
            regimenestadoDAO.actualizar(regimenEstado);
        });

    }

    /**
     * Test of consultar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testConsultar_Inexistente() throws Exception {
        System.out.println("Testing consultar inexistente...");
        MockitoAnnotations.openMocks(this);

        Mockito.doThrow(Exception.class).when(regimenestadoDAO).consultar(-1);

        assertThrows(Exception.class, () -> {
            regimenestadoDAO.consultar(-1);
        });
    }

    /**
     * Test of consultar method, of class RegimenEstadoDAO.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("Testing consultar...");
        MockitoAnnotations.openMocks(this);
        RegimenEstado regimenEstadoEsperado = new RegimenEstado(1, "Prueba consultar", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        Mockito.when(regimenestadoDAO.consultar(1)).thenReturn(regimenEstadoEsperado);
        
        assertEquals(regimenEstadoEsperado, regimenestadoDAO.consultar(1));

        
    }

    /**
     * Test of consultarTodos method, of class RegimenEstadoDAO.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        System.out.println("Testing consultar todos...");
        MockitoAnnotations.openMocks(this);
        List<RegimenEstado> regimenEstados = new ArrayList<>();
        
        RegimenEstado regimenEstado1 = new RegimenEstado(1, "Prueba consultar", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        RegimenEstado regimenEstado2 = new RegimenEstado(2, "Prueba consultar", usuarioDAO.consultar(2), Estado.NO_APROBADO);

        regimenEstados.add(regimenEstado1);
        regimenEstados.add(regimenEstado2);
        
        Mockito.when(regimenestadoDAO.consultarTodos()).thenReturn(regimenEstados);
        
        assertEquals(regimenEstados, regimenestadoDAO.consultarTodos());
    }

    /**
     * Test of consultarPorEntrenador method, of class RegimenEstadoDAO.
     */
    @Test
    public void testConsultarPorEntrenador() throws Exception {
        System.out.println("Testing consultar por entrenador...");
        MockitoAnnotations.openMocks(this);
        List<RegimenEstado> regimenEstados = new ArrayList<>();
        
        RegimenEstado regimenEstado1 = new RegimenEstado(1, "Prueba consultar", usuarioDAO.consultar(1), Estado.NO_APROBADO);
        RegimenEstado regimenEstado2 = new RegimenEstado(2, "Prueba consultar", usuarioDAO.consultar(2), Estado.NO_APROBADO);

        regimenEstados.add(regimenEstado1);
        regimenEstados.add(regimenEstado2);
        
        Mockito.when(regimenestadoDAO.consultarTodos()).thenReturn(regimenEstados);

        assertEquals(regimenEstados, regimenestadoDAO.consultarTodos());
    }

}