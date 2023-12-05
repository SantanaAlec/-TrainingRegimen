/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.Regimen;
import com.itson.dominio.RegimenEstado;
import com.itson.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface IPersistencia {
    public void guardarRegimen(Regimen regimen) throws Exception;
    public Regimen consultarRegimen() throws Exception;
    public void agregarRegimenEstado(RegimenEstado regimenEstado) throws Exception ;
    public void actualizarRegimenEstado(RegimenEstado regimenEstado) throws Exception ;
    public RegimenEstado consultarRegimenEstado(Integer idRegimenEstado) throws Exception ;
    public void eliminarRegimenEstado(Integer idRegimenEstado) throws Exception ;
    public RegimenEstado consultarRegimenEstadoPorEntrenador(Integer idEntrenador) throws Exception ;
    public List<RegimenEstado> consultarTodosRegimenEstado() throws Exception ;
    public void agregarUsuario(Usuario usuario) throws Exception ;
    public void eliminarUsuario(Integer idUsuario) throws Exception ;
    public void actualizarUsuario(Usuario usuario) throws Exception ;
    public Usuario consultarUsuario(Integer idUsuario) throws Exception ;
    public Usuario consultarUsuario(String nombre)throws Exception ;
    public List<Usuario> consultarTodosUsuarios()throws Exception ;
    public List<Usuario> consultarEntrenadores()throws Exception ;
    public void actualizarRegimen(Regimen regimen)throws Exception;
}
