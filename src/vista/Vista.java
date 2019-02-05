package vista;

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

import java.util.Scanner;

import modelo.Coche;

public class Vista {

	private static Scanner sc = new Scanner(System.in);

	public static String askData(String s) {
		if (!s.equals("")) {
			System.out.println(s);
		}
		return sc.nextLine();
	}

	public static void printErrLn(String s) {
		System.err.println(s);
	}

	public static void print(String s) {
		System.out.print(s);
	}

	public static void printErr(String s) {
		System.err.print(s);
	}

	public static void printLn(String s) {
		System.out.println(s);
	}

	public static void retornoLinea() {
		System.out.println();
	}

}
