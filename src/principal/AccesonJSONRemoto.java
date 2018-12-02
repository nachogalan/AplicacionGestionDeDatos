package principal;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import auxiliares.ApiRequests;
import modelo.Coches;
import modelo.Marcas;

public class AccesonJSONRemoto {

	ApiRequests encargadoPeticiones;
	private String SERVER_PATH, GET_COCHE, GET_MARCA, SET_COCHE, SET_MARCA; // Datos de la conexion

	public AccesonJSONRemoto() {

		encargadoPeticiones = new ApiRequests();

		SERVER_PATH = "http://localhost/nacho/CochesJSONServer/";
		GET_COCHE = "leeCoches.php";
		GET_MARCA = "leeMarcas.php";
		SET_COCHE = "escribirCoche.php";
		SET_MARCA = "escribirMarca.php";

	}
	
	public HashMap<Integer, Marcas> leeMarca(){
		
		HashMap<Integer, Marcas> auxhm = new HashMap<Integer, Marcas>();
		
		try {

			System.out.println("---------- Leemos datos de JSON --------------------");

			System.out.println("Lanzamos peticion JSON para marcas");

			String url = SERVER_PATH + GET_MARCA; // Sacadas de configuracion

			System.out.println("La url a la que lanzamos la petición es " +
			 url); 
			// Traza para pruebas

			String response = encargadoPeticiones.getRequest(url);
			
			System.out.println(response); // Traza para pruebas

			// Parseamos la respuesta y la convertimos en un JSONObject
			JSONObject respuesta = (JSONObject) JSONValue.parse(response.toString());

			if (respuesta == null) { // Si hay algún error de parseo (json
										// incorrecto porque hay algún caracter
										// raro, etc.) la respuesta será null
				System.out.println("El json recibido no es correcto. Finaliza la ejecución");
				System.exit(-1);
			} else { // El JSON recibido es correcto
				// Sera "ok" si todo ha ido bien o "error" si hay algún problema
				String estado = (String) respuesta.get("estado"); 
				// Si ok, obtenemos array de jugadores para recorrer y generar hashmap
				if (estado.equals("ok")) { 
					JSONArray array = (JSONArray) respuesta.get("equipos");

					if (array.size() > 0) {

						// Declaramos variables
						Marcas nuevaMarca;
						String nombre;
						String sede;
						int id;

						for (int i = 0; i < array.size(); i++) {
							JSONObject row = (JSONObject) array.get(i);
							
							id = Integer.parseInt(row.get("idFabricante").toString());
							nombre = row.get("nombre").toString();
							sede = row.get("sede").toString();
							
							
							

							nuevaMarca = new Marcas(id, nombre, sede);

							auxhm.put(id, nuevaMarca);
						}

						System.out.println("Acceso JSON Remoto - Leidos datos correctamente y generado hashmap");
						System.out.println();

					} else { // El array de jugadores está vacío
						System.out.println("Acceso JSON Remoto - No hay datos que tratar");
						System.out.println();
					}

				} else { // Hemos recibido el json pero en el estado se nos
							// indica que ha habido algún error

					System.out.println("Ha ocurrido un error en la busqueda de datos");
					System.out.println("Error: " + (String) respuesta.get("error"));
					System.out.println("Consulta: " + (String) respuesta.get("query"));

					System.exit(-1);

				}
			}

		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en la busqueda de datos");

			e.printStackTrace();

			System.exit(-1);
		}

		
		return auxhm;
		
	}

	public HashMap<Integer, Coches> lee() {

		HashMap<Integer, Coches> auxhm = new HashMap<Integer, Coches>();

		try {

			System.out.println("---------- Leemos datos de JSON --------------------");

			System.out.println("Lanzamos peticion JSON para coches");

			String url = SERVER_PATH + GET_COCHE; // Sacadas de configuracion

			// System.out.println("La url a la que lanzamos la petición es " +
			// url); 
			// Traza para pruebas

			String response = encargadoPeticiones.getRequest(url);

			 System.out.println(response); // Traza para pruebas

			// Parseamos la respuesta y la convertimos en un JSONObject
			JSONObject respuesta = (JSONObject) JSONValue.parse(response.toString());

			if (respuesta == null) { // Si hay algún error de parseo (json
										// incorrecto porque hay algún caracter
										// raro, etc.) la respuesta será null
				System.out.println("El json recibido no es correcto. Finaliza la ejecución");
				System.exit(-1);
			} else { // El JSON recibido es correcto
				// Sera "ok" si todo ha ido bien o "error" si hay algún problema
				String estado = (String) respuesta.get("estado"); 
				// Si ok, obtenemos array de jugadores para recorrer y generar hashmap
				if (estado.equals("ok")) { 
					JSONArray array = (JSONArray) respuesta.get("coches");

					if (array.size() > 0) {

						// Declaramos variables
						Coches nuevoCoche;
						
						String nombre;
						String descripcion;
						String caracteristica1;
						String caracteristica2;
						int id_fabricante;
						
						int id;

						for (int i = 0; i < array.size(); i++) {
							JSONObject row = (JSONObject) array.get(i);

							nombre = row.get("nombre").toString();
							descripcion = row.get("descripcion").toString();
							caracteristica1 = row.get("caracteristica1").toString();
							caracteristica2 = row.get("caracteristica2").toString();
							id_fabricante = Integer.parseInt(row.get("idFabricante").toString());
							id = Integer.parseInt(row.get("id").toString());
							

							nuevoCoche = new Coches(id, nombre, descripcion, caracteristica1,caracteristica2, id_fabricante);

							auxhm.put(id, nuevoCoche);
						}

						System.out.println("Acceso JSON Remoto - Leidos datos correctamente y generado hashmap");
						System.out.println();

					} else { // El array de jugadores está vacío
						System.out.println("Acceso JSON Remoto - No hay datos que tratar");
						System.out.println();
					}

				} else { // Hemos recibido el json pero en el estado se nos
							// indica que ha habido algún error

					System.out.println("Ha ocurrido un error en la busqueda de datos");
					System.out.println("Error: " + (String) respuesta.get("error"));
					System.out.println("Consulta: " + (String) respuesta.get("query"));

					System.exit(-1);

				}
			}

		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en la busqueda de datos");

			e.printStackTrace();

			System.exit(-1);
		}

		return auxhm;
	}
	
	

	public void anadirCocheJSON(Coches auxCoches) {

		try {
			JSONObject objCoche = new JSONObject();
			JSONObject objPeticion = new JSONObject();

			objCoche.put("nombre", auxCoches.getNombre());
			objCoche.put("descripcion", auxCoches.getDescripcion());
			objCoche.put("caracteristica1", auxCoches.getCaracteristica1());
			objCoche.put("caracteristica2", auxCoches.getCaracteristica2());
			objCoche.put("idFabricante", auxCoches.getIdMarca());
			

			// Tenemos el jugador como objeto JSON. Lo añadimos a una peticion
			// Lo transformamos a string y llamamos al
			// encargado de peticiones para que lo envie al PHP

			objPeticion.put("peticion", "add");
			objPeticion.put("cocheAnnadir", objCoche);
			
			String json = objPeticion.toJSONString();

			System.out.println("Lanzamos peticion JSON para almacenar un coche");

			String url = SERVER_PATH + SET_COCHE;

			System.out.println("La url a la que lanzamos la petición es " + url);
			System.out.println("El json que enviamos es: ");
			System.out.println(json);
			//System.exit(-1);

			String response = encargadoPeticiones.postRequest(url, json);
			
			System.out.println("El json que recibimos es: ");
			
			System.out.println(response); // Traza para pruebas
			System.exit(-1);
			
			// Parseamos la respuesta y la convertimos en un JSONObject
			

			JSONObject respuesta = (JSONObject) JSONValue.parse(response.toString());

			if (respuesta == null) { // Si hay algún error de parseo (json
										// incorrecto porque hay algún caracter
										// raro, etc.) la respuesta será null
				System.out.println("El json recibido no es correcto. Finaliza la ejecución");
				System.exit(-1);
			} else { // El JSON recibido es correcto
				
				// Sera "ok" si todo ha ido bien o "error" si hay algún problema
				String estado = (String) respuesta.get("estado"); 
				if (estado.equals("ok")) {

					System.out.println("Almacenado jugador enviado por JSON Remoto");

				} else { // Hemos recibido el json pero en el estado se nos
							// indica que ha habido algún error

					System.out.println("Acceso JSON REMOTO - Error al almacenar los datos");
					System.out.println("Error: " + (String) respuesta.get("error"));
					System.out.println("Consulta: " + (String) respuesta.get("query"));

					System.exit(-1);

				}
			}
		} catch (Exception e) {
			System.out.println(
					"Excepcion desconocida. Traza de error comentada en el método 'annadirCoche' de la clase JSON REMOTO");
			// e.printStackTrace();
			System.out.println("Fin ejecución");
			System.exit(-1);
		}

	}
	
	public void anadirMarcaJSON(Marcas auxEquipo) {

		try {
			JSONObject objMarca = new JSONObject();
			JSONObject objPeticion = new JSONObject();
			
			
			objMarca.put("nombre", auxEquipo.getNombre());
			objMarca.put("sede", auxEquipo.getSede());
			

			// Tenemos el jugador como objeto JSON. Lo añadimos a una peticion
			// Lo transformamos a string y llamamos al
			// encargado de peticiones para que lo envie al PHP

			objPeticion.put("peticion", "add");
			objPeticion.put("marcaAnnadir", objMarca);
			
			String json = objPeticion.toJSONString();

			System.out.println("Lanzamos peticion JSON para almacenar una marca");

			String url = SERVER_PATH + SET_MARCA;

			System.out.println("La url a la que lanzamos la petición es " + url);
			System.out.println("El json que enviamos es: ");
			System.out.println(json);
			//System.exit(-1);

			String response = encargadoPeticiones.postRequest(url, json);
			
			System.out.println("El json que recibimos es: ");
			
			System.out.println(response); // Traza para pruebas
			System.exit(-1);
			
			// Parseamos la respuesta y la convertimos en un JSONObject
			

			JSONObject respuesta = (JSONObject) JSONValue.parse(response.toString());

			if (respuesta == null) { // Si hay algún error de parseo (json
										// incorrecto porque hay algún caracter
										// raro, etc.) la respuesta será null
				System.out.println("El json recibido no es correcto. Finaliza la ejecución");
				System.exit(-1);
			} else { // El JSON recibido es correcto
				
				// Sera "ok" si todo ha ido bien o "error" si hay algún problema
				String estado = (String) respuesta.get("estado"); 
				if (estado.equals("ok")) {

					System.out.println("Almacenado jugador enviado por JSON Remoto");

				} else { // Hemos recibido el json pero en el estado se nos
							// indica que ha habido algún error

					System.out.println("Acceso JSON REMOTO - Error al almacenar los datos");
					System.out.println("Error: " + (String) respuesta.get("error"));
					System.out.println("Consulta: " + (String) respuesta.get("query"));

					System.exit(-1);

				}
			}
		} catch (Exception e) {
			System.out.println(
					"Excepcion desconocida. Traza de error comentada en el método 'annadirMarca' de la clase JSON REMOTO");
			// e.printStackTrace();
			System.out.println("Fin ejecución");
			System.exit(-1);
		}

	}

}
