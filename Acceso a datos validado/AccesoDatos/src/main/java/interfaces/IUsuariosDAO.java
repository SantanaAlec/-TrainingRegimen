/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;


import com.itson.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface IUsuariosDAO {
    public void agregar(Usuario usuario)throws Exception;
    public void eliminar(Integer idUsuario)throws Exception;
    public void actualizar(Usuario usuario)throws Exception;
    public Usuario consultar(Integer idUsuario)throws Exception;
    public Usuario consultar(String nombre)throws Exception;
    public List<Usuario> consultarTodos()throws Exception;
}
