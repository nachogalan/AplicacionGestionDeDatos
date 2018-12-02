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

public class Marca {

	int id_fabricante;
	String Nombre;
	String Sede;
	
	public Marca(int id_fabricante, String nombre, String sede) {
		super();
		this.id_fabricante = id_fabricante;
		Nombre = nombre;
		Sede = sede;
	}
	
	public Marca() {
	}

	public int getId_fabricante() {
		return id_fabricante;
	}
	public void setId_fabricante(int id_fabricante) {
		this.id_fabricante = id_fabricante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getSede() {
		return Sede;
	}
	public void setSede(String sede) {
		Sede = sede;
	}

	public String toString(){
		String aux ="";
		
		aux += "------------------------------------------";
		aux += "\n	ID: " + this.id_fabricante;
		aux += "\n	NOMBRE: " + this.Nombre;
		aux += "\n	SEDE: " + this.Sede;
		aux += "\n------------------------------------------";
		
		return aux;
	}
	
}
