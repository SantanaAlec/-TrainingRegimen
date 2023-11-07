// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package implementaciones;

import com.google.gson.Gson;
import com.itson.dominio.Regimen;
import interfaces.IRegimenDAO;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegimenDAO implements IRegimenDAO {

    @Override
    public void guardar(Regimen regimen) {
        try (FileWriter file = new FileWriter("regimen.json")) {

            file.write(new Gson().toJson(regimen));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Regimen consultar() {

        try (FileReader reader = new FileReader("regimen.json")) {

            Regimen regimen = new Gson().fromJson(reader, Regimen.class);
            return regimen;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(RegimenDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

}
