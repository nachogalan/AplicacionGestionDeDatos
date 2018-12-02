package modelo;

public class Coches {

	int id;
	String nombre;
	String descripcion;
	String caracteristica1;
	String caracteristica2;
	Marcas marca;
	int idMarca;
	
	public Coches(int id, String nombre, String descripcion, String caracteristica1, String caracteristica2,
			 int idMarca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caracteristica1 = caracteristica1;
		this.caracteristica2 = caracteristica2;
		
		this.idMarca = idMarca;
	}
	
	public Coches(String nombre, String descripcion, String caracteristica1, String caracteristica2,
			 int idMarca) {
		super();
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caracteristica1 = caracteristica1;
		this.caracteristica2 = caracteristica2;
		
		this.idMarca = idMarca;
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

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	public String toString(){
		String aux ="";
		
		aux += "------------------------------------------";
		aux += "\n	ID: " + this.id;
		aux += "\n	NOMBRE: " + this.nombre;
		aux += "\n	CARACTERISTICA 1: " + this.caracteristica1;
		aux += "\n	CARACTERISTICA 2: " + this.caracteristica2;
		aux += "\n	ID MARCA: " + this.idMarca;
		aux += "\n------------------------------------------";
		
		return aux;
	}
	
	
	
	

}
