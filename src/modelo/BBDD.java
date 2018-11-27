package modelo;

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

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class BBDD implements Data {

	private String bd = "abd_coches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String login = "";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;
	Marca marca = new Marca(0, "", "");
	Coche coche = new Coche(0, "", "", "", "", marca);
	HashMap<String, Marca> marcaMap = new HashMap<>();
	HashMap<String, Coche> cocheMap = new HashMap<>();

	public BBDD() {

		try {
			Properties p = new Properties();
			p.load(new FileInputStream("bbdd.ini"));
			login = p.getProperty("Usuario");
			pwd = p.getProperty("Contrasena");
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println(" - Conexión con MySQL establecida -");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void updateCoche(Coche ch) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void uploadCoche(Coche ch) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void deleteCoche(Coche ch) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public Coche[] getCoche() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public void updateMarca(Marca mc) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void uploadMarca(Marca mc) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void deleteMarca(Marca mc) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public Marca[] getMarca() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}
