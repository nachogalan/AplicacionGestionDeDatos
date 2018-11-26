import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import modelo.Configurador;
import modelo.Data;

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
		try {
			cl = Class.forName("modelo."+menuData.getProperty(option));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Object tmp = (Object) cl;
		
		Data d = (Data) tmp;

		d.getData();
		
	}
}