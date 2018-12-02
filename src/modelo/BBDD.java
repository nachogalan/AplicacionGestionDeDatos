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
import java.sql.ResultSet;
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

	private final String[] columnasCoches = { "ID", "Nombre", "Descripcion", "Caracteristica1", "Caracteristica2",
			"ID_Fabricante" };
	private final String[] columnasMarcas = { "ID_Fabricante", "Nombre", "Sede" };

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
			System.out.println(" - Conexión con MySQL establecida -");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String[] getArFromCar(Coche ch) {
		return new String[] { Integer.toString(ch.getId()), ch.getNombre(), ch.getDescripcion(),
				ch.getCaracteristica1(), ch.getCaracteristica2(), Integer.toString(ch.getMarca().getId_fabricante()) };
	}

	private String[] getArFromMarca(Marca mc) {
		return new String[] {Integer.toString(mc.getId_fabricante()), mc.getNombre(), mc.getSede()};
	}

	@Override
	public void updateCoche(Coche ch) {
		conexion.editarDatos(this.tableCoche, this.columnasCoches, this.getArFromCar(ch), "ID =" + ch.getId());
	}

	@Override
	public void uploadCoche(Coche ch) {
		conexion.insertarDatos(this.tableCoche, this.columnasCoches, this.getArFromCar(ch));

	}

	@Override
	public void deleteCoche(Coche ch) {
		conexion.borrarFila(this.tableCoche, "ID = " + ch.getId());
	}

	@Override
	public HashMap<Integer, Coche> getCoche() {
		HashMap<Integer, Coche> result = new HashMap<Integer, Coche>();
		ResultSet rs = conexion.Consulta("SELECT * FROM " + this.tableCoche);
		try {
			int i = 0;
			while (rs.next()) {
				ResultSet tmpRset = conexion.Consulta("SELECT * FROM "+this.tableCoche+" WHERE ID = "+rs.getInt(5));
				tmpRset.next();
				Marca mc = new Marca(tmpRset.getInt(0), tmpRset.getString(1), tmpRset.getString(2));
				result.put(i, new Coche(rs.getInt(0),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), mc));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void updateMarca(Marca mc) {
		conexion.editarDatos(this.tableMarca, this.columnasMarcas, this.getArFromMarca(mc), "ID =" + mc.getId_fabricante());
	}

	@Override
	public void uploadMarca(Marca mc) {
		conexion.insertarDatos(this.tableMarca, this.columnasMarcas, this.getArFromMarca(mc));

	}

	@Override
	public void deleteMarca(Marca mc) {
		conexion.borrarFila(this.tableMarca, "ID = " + mc.getId_fabricante());

	}

	@Override
	public HashMap<Integer, Marca> getMarca() {
		HashMap<Integer, Marca> result = new HashMap<Integer, Marca>();
		System.out.println("SELECT * FROM " + this.tableCoche);
		ResultSet rs = conexion.Consulta("SELECT * FROM " + this.tableCoche);
		try {
			int i = 0;
			while (rs.next()) {
				result.put(i, new Marca(rs.getInt(0), rs.getString(1), rs.getString(2)));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
