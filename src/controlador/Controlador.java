package controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import modelo.Coche;
import modelo.Configurador;
import modelo.Data;
import modelo.Marca;
import vista.Vista;

public class Controlador {

	public static void start() {
		Properties menuData = new Properties();

		try {
			menuData = Configurador.getMenuData();
		} catch (IOException e) {
			Vista.printErrLn("No se encontro el archivo de configuracion de clases, cerrando programa.");
			System.exit(-1);
		}

		int x = 0;
		HashMap<Integer, String> hs = new HashMap<Integer, String>();
		for (Object c : menuData.keySet()) {
			hs.put(x, (String) c);
			x++;
		}

		for (int i = 0; i < hs.size(); i++) {
			System.out.println(i + "." + hs.get(i));
		}

		String option = hs.get(Integer.parseInt(Vista.askData("Introduzca un numero asociado a una opcion:")));
		Class cl = null;
		Data dt = null;
		try {
			cl = Class.forName("modelo." + menuData.getProperty(option));
			dt = (Data) cl.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	public static Coche getCoche(Data caller) {
		Coche result = new Coche();
		boolean check = false;
		while (!check) {
			try {
				result.setId(Integer.parseInt(Vista.askData("Introduce el ID del coche: ")));
			} catch (NumberFormatException e) {
				Vista.printErrLn("Numero incorrecto, vuelve a intentarlo");
			}
			check = true;
		}
		result.setNombre(Vista.askData("Introduce el nombre del coche: "));
		result.setCaracteristica1(Vista.askData("Introduce la caracteristica 1 del coche: "));
		result.setCaracteristica2(Vista.askData("Introduce la caracteristica 2 del coche: "));
		result.setDescripcion(Vista.askData("Introduce la descripcion del coche: "));

		Vista.retornoLinea();
		int i = 0;
		Marca [] mcArray = caller.getMarca();
		for (Marca mc : mcArray) {
			System.out.println(i + "." + mc.getNombre());
			i++;
		}
		Marca mc = null;
		check = false;
		while (!check) {
			try {
				mc = mcArray[Integer
						.parseInt((Vista.askData("Introduce el numero de la marca del coche")))];
				result.setMarca(mc);
			} catch (NumberFormatException | NullPointerException e) {
				Vista.printErrLn("Numero incorrecto, vuelve a intentarlo");
			}
			check = true;
		}
		result.setMarca(mc);
		return result;
	}

	public static Marca getMarca(Data caller) {
		Marca result = new Marca();
		boolean check = false;
		while (!check) {
			try {
				result.setId_fabricante	(Integer.parseInt(Vista.askData("Introduce el ID del coche: ")));
			} catch (NumberFormatException e) {
				Vista.printErrLn("Numero incorrecto, vuelve a intentarlo");
			}
			check = true;
		}
		result.setNombre(Vista.askData("Introduce el nombre de la marca: "));
		result.setSede(Vista.askData("Introduce la sede: "));
		return result;
		
	}
}