package modelo;

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

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class BBDD implements Data {

	private String bd = "";
	private String login = "";
	private String pwd = "";
	private Conexion conexion;
	private String tableCoche = "";
	private String tableMarca = "";
	Marca marca = new Marca(0, "", "");
	Coche coche = new Coche(0, "", "", "", "", marca);
	HashMap<String, Marca> marcaMap = new HashMap<>();
	HashMap<String, Coche> cocheMap = new HashMap<>();

	public BBDD() {

			Properties p = new Properties();
			try {
				p.load(new FileInputStream("bbdd.ini"));
				login = p.getProperty("Usuario");
				pwd = p.getProperty("Contrasena");
				tableCoche = p.getProperty("tablaCoche");
				tableMarca = p.getProperty("tablaMarca");
				bd = p.getProperty("db");
				conexion = new Conexion(bd, login, pwd, true);
				System.out.println(" - Conexi�n con MySQL establecida -");
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	@Override
	public void updateCoche(Coche ch) {
		conexion.editarDatos(tableCoche, columnas, valores, condicion)
	}

	@Override
	public void uploadCoche(Coche ch) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

	@Override
	public void deleteCoche(Coche ch) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

	@Override
	public HashMap<Integer, Coche> getCoche() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	public void updateMarca(Marca mc) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

	@Override
	public void uploadMarca(Marca mc) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

	@Override
	public void deleteMarca(Marca mc) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

	@Override
	public HashMap<Integer, Marca> getMarca() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

}
