public class Coche {

    String id;    
    String nombre;
    String descripcion;
    String caracteristica1;
    String caracteristica2;
    
    Marca marca;

	public Coche(String id, String nombre, String descripcion, String caracteristica1, String caracteristica2,
			Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caracteristica1 = caracteristica1;
		this.caracteristica2 = caracteristica2;
		this.marca = marca;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

   
}
