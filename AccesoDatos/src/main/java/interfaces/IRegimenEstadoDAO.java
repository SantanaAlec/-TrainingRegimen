/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.RegimenEstado;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface IRegimenEstadoDAO {
    public void agregar(RegimenEstado regimenEstado);
    public void actualizar(RegimenEstado regimenEstado);
    public RegimenEstado consultar(Integer idRegimenEstado);
    public List<RegimenEstado> consultarTodos();
}
