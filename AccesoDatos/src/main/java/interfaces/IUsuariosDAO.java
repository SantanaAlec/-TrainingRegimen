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
    public void agregar(Usuario usuario);
    public void eliminar(Integer idUsuario);
    public void actualizar(Usuario usuario);
    public Usuario consultar(Integer idUsuario);
    public Usuario consultar(String nombre);
    public List<Usuario> consultarTodos();
}
