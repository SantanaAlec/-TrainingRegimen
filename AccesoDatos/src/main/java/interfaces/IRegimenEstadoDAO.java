/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.RegimenEstado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface IRegimenEstadoDAO {
    public void agregar(RegimenEstado regimenEstado) throws Exception ;
    public void actualizar(RegimenEstado regimenEstado) throws Exception ;
    public RegimenEstado consultar(Integer idRegimenEstado) throws Exception ;
    public void eliminar(Integer idRegimenEstado) throws Exception ;
    public RegimenEstado consultarPorEntrenador(Integer idEntrenador) throws Exception ;
    public List<RegimenEstado> consultarTodos() throws Exception ;
    public void eliminarPorNombres(ArrayList<String>nombres) throws Exception;
    public RegimenEstado consultarPorNombre(String nombre) throws Exception;
}
