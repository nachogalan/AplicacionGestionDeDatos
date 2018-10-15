
public class Marca {
	
	
	public Marca(String id_fabricante, String nombre, String sede) {
		super();
		this.id_fabricante = id_fabricante;
		Nombre = nombre;
		Sede = sede;
	}
	
	public String getId_fabricante() {
		return id_fabricante;
	}
	public void setId_fabricante(String id_fabricante) {
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

	String id_fabricante;
	String Nombre;
	String Sede;
}
