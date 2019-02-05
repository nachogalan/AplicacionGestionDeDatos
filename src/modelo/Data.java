package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/*
 *Creado por Elias Peria�ez
 *27 nov. 2018
 *Como parte del proyecto AppJaime v.2
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (M�s informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Peria�ez
 *27 nov. 2018
 *As part of the project AppJaime v.2
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public interface Data {

	public void updateCoche(Coche ch, Coche oldCoche);
	public void uploadCoche(Coche ch) throws SQLException, IOException;
	public void deleteCoche(Coche ch);

	public HashMap<Integer, Coche> getCoche() throws SQLException, FileNotFoundException;
	public void updateMarca(Marca newMarca, Marca oldMarca);
	public void uploadMarca(Marca mc) throws SQLException, IOException;
	public void deleteMarca(Marca mc);
	public HashMap<Integer, Marca> getMarca() throws SQLException;
}
