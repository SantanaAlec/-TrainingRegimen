// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package implementaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itson.dominio.Regimen;
import interfaces.IRegimenDAO;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.LocalDateAdapter;

public class RegimenDAO implements IRegimenDAO {

    @Override
    public void guardar(Regimen regimen) throws Exception{
        try (FileWriter file = new FileWriter("regimen.json")) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            file.write(gson.toJson(regimen));
            file.flush();

        } catch (IOException e) {
            System.out.println("Ocurrio algun error al guardar el archivo");
        }
    }

    @Override
    public Regimen consultar() throws Exception{

        try (FileReader reader = new FileReader("regimen.json")) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            Regimen regimen = gson.fromJson(reader, Regimen.class);
            return regimen;
         } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo que quiere consultar");
        } catch (IOException ex) {
           // Logger.getLogger(RegimenDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ocurrió algún error al consultar el archivo");
        }
        return null;
    }

}
