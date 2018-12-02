package modelo;

public class Marcas {
	int idFabricante;
	String nombre;
	String sede;
	
	public Marcas(int id, String nombre,String sede) {
		super();
		this.idFabricante = id;
		this.nombre = nombre;
		this.sede = sede;
	}
	
	public Marcas( String nombre,String sede) {
		super();
		this.nombre = nombre;
		this.sede = sede;
	}

	public int getId() {
		return idFabricante;
	}

	public void setId(int id) {
		this.idFabricante = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public String toString(){
		String aux ="";
		
		aux += "------------------------------------------";
		aux += "\n	ID: " + this.idFabricante;
		aux += "\n	NOMBRE: " + this.nombre;
		aux += "\n	SEDE: " + this.sede;
		aux += "\n------------------------------------------";
		
		return aux;
	}
	
	
	
}
