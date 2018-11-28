package modelo;

import java.util.ArrayList;
import java.util.HashMap;

/*
 *Creado por Elias Periañez
 *27 nov. 2018
 *Como parte del proyecto AppJaime v.2
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (Más informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Periañez
 *27 nov. 2018
 *As part of the project AppJaime v.2
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public interface Data {

	public void updateCoche(Coche ch);
	public void uploadCoche(Coche ch);
	public void deleteCoche(Coche ch);
	public HashMap<Integer, Coche> getCoche();
	public void updateMarca(Marca mc);
	public void uploadMarca(Marca mc);
	public void deleteMarca(Marca mc);
	public HashMap<Integer, Marca> getMarca();
}
