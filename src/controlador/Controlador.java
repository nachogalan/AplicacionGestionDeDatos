package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import modelo.Coche;
import modelo.Configurador;
import modelo.Data;
import modelo.Marca;
import vista.Vista;

public class Controlador {

	public static void start() throws SQLException, IOException {
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
		menu(dt);
	}

	public static Coche getCoche(Data caller) throws SQLException {
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
		HashMap<Integer, Marca> mcArray = caller.getMarca();
		Map<Integer, Marca> mp = mcArray;
		Iterator<Entry<Integer, Marca>> datos = mp.entrySet().iterator();

		int i = 0;
		while (datos.hasNext()) {
			System.out.println(i + "." + datos.next().getValue());
			i++;
		}

		Marca mc = null;
		check = false;
		while (!check) {
			mc = mcArray.get(Integer.parseInt((Vista.askData("Introduce el numero de la marca del coche"))));

			if (mc != null) {
				result.setMarca(mc);
				check = true;
			}
		}
		return result;
	}

	public static Marca getMarca() {
		Marca result = new Marca();
		boolean check = false;
		while (!check) {
			try {
				result.setId_fabricante(Integer.parseInt(Vista.askData("Introduce el ID del coche: ")));
			} catch (NumberFormatException e) {
				Vista.printErrLn("Numero incorrecto, vuelve a intentarlo");
			}
			check = true;
		}
		result.setNombre(Vista.askData("Introduce el nombre de la marca: "));
		result.setSede(Vista.askData("Introduce la sede: "));
		return result;

	}

	private static void menu(Data caller) throws SQLException, IOException {
		Vista.printLn("Elige si trabajar con marcas o con coches:");
		Vista.retornoLinea();
		Vista.printLn("1.Marcas");
		Vista.printLn("2.Coches");
		try {

			switch (Integer.parseInt(Vista.askData(""))) {
			case 1:
				menuMarcas(caller);
				break;

			case 2:
				menuCoches(caller);
				break;
			default:
				throw new NumberFormatException();
			}

		} catch (NumberFormatException e) {
			Vista.printErrLn("Numero incorrecto, vuelve a intentarlo");
			menu(caller);
		}
	}

	private static void menuMarcas(Data caller) throws SQLException, IOException {
		Vista.printLn("Elija una opcion:");
		Vista.retornoLinea();
		Vista.printLn("1.Ver marcas actuales");
		Vista.printLn("2.Crear nueva marca");
		Vista.printLn("3.Actualizar una marca");
		Vista.printLn("4.Borrar una marca");
		Vista.printLn("5.Volver atras");
		Vista.printLn("6.Salir");

		try {
			switch (Integer.parseInt(Vista.askData(""))) {
			case 1:
				Iterator<Entry<Integer, Marca>> it = caller.getMarca().entrySet().iterator();
				while(it.hasNext()) {
					Vista.printLn("-"+it.next().getValue().getNombre());
				}
				Vista.retornoLinea();
				menuMarcas(caller);
				break;
			case 2:
				caller.uploadMarca(getMarca());
				menuMarcas(caller);
				break;
			case 3:
				caller.updateMarca(getMarca());
				menuMarcas(caller);
				break;
			case 4:
				caller.deleteMarca(getMarca());
				menuMarcas(caller);
				break;
			case 5:
				menu(caller);
				break;
				
			case 6:
				System.exit(0);
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			Vista.printErrLn("Numero incorrecto, vuelve a intentarlo");
			menuMarcas(caller);
		}
	}

	private static void menuCoches(Data caller) throws SQLException, IOException {
		Vista.printLn("Elija una opcion:");
		Vista.retornoLinea();
		Vista.printLn("1.Ver los coches actuales");
		Vista.printLn("2.Crear nuevo coche");
		Vista.printLn("3.Actualizar un coche");
		Vista.printLn("4.Borrar un coche");
		Vista.printLn("5.Volver atras");
		Vista.printLn("6.Salir");

		try {
			switch (Integer.parseInt(Vista.askData(""))) {
			case 1:
				Iterator<Entry<Integer, Coche>> it = caller.getCoche().entrySet().iterator();
				while(it.hasNext()) {
					Vista.printLn("-"+it.next().getValue().getNombre());
				}
				Vista.retornoLinea();
				menuCoches(caller);
				break;
			case 2:
				caller.uploadCoche(getCoche(caller));
				menuCoches(caller);
				break;
			case 3:
				caller.updateCoche(getCoche(caller));
				menuCoches(caller);
				break;
			case 4:
				caller.deleteCoche(getCoche(caller));
				menuCoches(caller);
				break;
			case 5:
				menu(caller);
				break;
				
			case 6:
				System.exit(0);
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException | FileNotFoundException e) {
			Vista.printErrLn("Numero incorrecto, vuelve a intentarlo");
			menuCoches(caller);
		}
	}
}