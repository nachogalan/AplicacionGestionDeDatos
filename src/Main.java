import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {

		Controlador control = new Controlador();

		Scanner sc = new Scanner(System.in);

		boolean salir = false;
		int eleccion;
		while (!salir) {

			System.out.print("Pulse 1 si desea gestionar la BBDD" + "\n");
			System.out.print("Pulse 2 si desea gestionar el fichero " + "\n");
			System.out.print("Pulse 3 para terminar el programa " + "\n");

			sc = new Scanner(System.in);
			eleccion = sc.nextInt();

			switch (eleccion) {

			case 1:
				control.acces = new ConexionBBDD();
				break;

			case 2:
				control.acces = new GestionArchivos();
				break;
			case 3:
				System.exit(0);
				break;
			}

			System.out.print("Pulse 1 para añadir" + "\n");
			System.out.print("Pulse 2 para Leer" + "\n");
			System.out.print("Pulse 3 para Actualizar" + "\n");
			System.out.print("Pulse 4 para Borrar" + "\n");
			System.out.print("Pulse 5 para pasar de la BBDD al TXT" + "\n");
			System.out.print("Pulse 6 para pasar deL TXT a la BBDD" + "\n");

			eleccion = sc.nextInt();

			switch (eleccion) {
			case 1:

				control.getAcces().Escribir();
				break;

			case 2:
				control.getAcces().Leer();
				break;
			case 3:
				control.getAcces().Actualizar();
				break;
			case 4:
				control.getAcces().Borrar();
				break;
			case 5:
				control.getAcces().BBDDTXT();
				break;

			case 6:
				control.getAcces().TXTABBDD();
				break;

			}
		}
	}
}