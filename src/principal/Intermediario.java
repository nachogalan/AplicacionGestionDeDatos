package principal;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

import modelo.Coches;
import modelo.Marcas;

public class Intermediario {

	Scanner teclado;
	AccesonJSONRemoto acceso;

	public Intermediario() {
		this.teclado = new Scanner(System.in); // Para leer las opciones de										// teclado
		this.acceso = new AccesonJSONRemoto();
	}

	public void ejecucion() {
		int op = 0; // Opcion
		boolean salir = false;

		while (!salir) { // Estructura que repite el algoritmo del menu
							// principal hasta que se la condicion sea falsa
			// Se muestra el menu principal
			System.out.println();
			System.out.println("........ MENU ........... \n" + ".  0 Salir \n" + ".  1 Leer coches  \n"
					+ ".  2 Añadir coche \n" + ".  3 Leer marcas  \n" + ".  4 Añadir marca  \n"
					+ "..........................");
			try {
				op = teclado.nextInt();
				teclado.nextLine();
				System.out.println("OPCION SELECCIONADA:" + op);
				switch (op) {
				case 0:
					salir = true;
					break;
				case 1:
					HashMap<Integer, Coches> hm = leeCoches();
					pintaCoches(hm);
					break;
				case 2:
					Coches auxCoche = this.crearCoche();
					
					acceso.anadirCocheJSON(auxCoche);
				case 3:
					HashMap<Integer, Marcas> hme = leeMarcas();
					pintaMarcas(hme);
					break;
				case 4:
					Marcas auxMarca = this.crearMarca();
					
					acceso.anadirMarcaJSON(auxMarca);
					break;
				default:
					System.out.println("Opcion invalida: marque un numero de 0 a 4");
					break;
				}

				// System.exit(1);

			} catch (InputMismatchException e) {
				System.out.println("Excepcion por opcion invalida: marque un numero de 0 a 1");
				teclado.next();
			} catch (Exception e) {
				System.out.println(
						"Excepcion desconocida. Traza de error comentada en el método 'ejecucion' de la clase intermediario");
				// e.printStackTrace();
				System.out.println("Fin ejecución");
				System.exit(-1);
			}
		}

		// teclado.close();

	}

	private HashMap<Integer, Marcas> leeMarcas() {

		HashMap<Integer, Marcas> hmAux = acceso.leeMarca();

		return hmAux;

	}
	
	private HashMap<Integer, Coches> leeCoches() {

		HashMap<Integer, Coches> hmAux = acceso.lee();

		return hmAux;

	}

	private void pintaCoches(HashMap<Integer, Coches> map) {

		// Recorre el hashmap y va pintando los jugadores (utiliza el método
		// toString de la clase Jgador
		for (Map.Entry<Integer, Coches> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}

	}
	
	private void pintaMarcas(HashMap<Integer, Marcas> map) {

		// Recorre el hashmap y va pintando los jugadores (utiliza el método
		// toString de la clase Jgador
		for (Map.Entry<Integer, Marcas> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}

	}
	
	



	private Coches crearCoche() {

		String nombre;
		String descripcion;
		String caracteristica1;
		String caracteristica2;
		
		int marcaFK;
		Coches cAux = null;

		try {

			System.out.println("Escriba el nombre del coche a añadir");
			nombre = teclado.nextLine();
			System.out.println("Escriba la descripcion del coche a añadir");
			descripcion = teclado.nextLine();
			System.out.println("Escriba la caracteristica 1 del coche a añadir");
			caracteristica1 = teclado.nextLine();
			System.out.println("Escriba la caracteristica 2 a añadir");
			caracteristica2 = teclado.nextLine();
			System.out.println("Escriba el ID de la marca ");
			marcaFK = Integer.parseInt(teclado.nextLine());


			cAux = new Coches(nombre, descripcion, caracteristica1,caracteristica2,marcaFK);

		} catch (InputMismatchException e) {
			System.out.println("Excepcion por opcion invalida: marque un numero de 0 a 1");
			teclado.next();
		}

		return cAux;

	}

	
	private Marcas crearMarca() {

		String nombre;
		String sede;
		
		Marcas eAux = null;

		try {

			System.out.println("Escriba el nombre del marca a añadir");
			nombre = teclado.nextLine();
			System.out.println("Escriba el nombre de la sede a añadir");
			sede = teclado.nextLine();
			

			// Aquí lo lógico sería mostrar el listado de equipos y poder
			// seleccionar uno

		

			eAux = new Marcas(nombre, sede);

		} catch (InputMismatchException e) {
			System.out.println("Excepcion por opcion invalida: marque un numero de 0 a 1");
			teclado.next();
		}

		return eAux;

	}

}
