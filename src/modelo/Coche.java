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

public class Coche {

    int id;    
    String nombre;
    String descripcion;
    String caracteristica1;
    String caracteristica2;
    Marca marca;

	public Coche(int id, String nombre, String descripcion, String caracteristica1, String caracteristica2,
			Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caracteristica1 = caracteristica1;
		this.caracteristica2 = caracteristica2;
		this.marca = marca;
	}
	
	public Coche() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristica1() {
		return caracteristica1;
	}

	public void setCaracteristica1(String caracteristica1) {
		this.caracteristica1 = caracteristica1;
	}

	public String getCaracteristica2() {
		return caracteristica2;
	}

	public void setCaracteristica2(String caracteristica2) {
		this.caracteristica2 = caracteristica2;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString(){
		String aux ="";
		
		aux += "------------------------------------------";
		aux += "\n	ID: " + this.id;
		aux += "\n	NOMBRE: " + this.nombre;
		aux += "\n	CARACTERISTICA 1: " + this.caracteristica1;
		aux += "\n	CARACTERISTICA 2: " + this.caracteristica2;
		aux += "\n	ID MARCA: " + this.marca.id_fabricante;
		aux += "\n------------------------------------------";
		
		return aux;
	}
	
	
   
}
