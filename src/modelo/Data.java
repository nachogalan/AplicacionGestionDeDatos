package modelo;

public interface Data {

	public void updateData(Coche ch);
	public void uploadData(Coche ch);
	public void deleteData(Coche ch);
	public Coche[] getData();
}
