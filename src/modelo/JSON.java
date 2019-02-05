package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class JSON implements Data{

	@Override
	public void updateCoche(Coche ch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadCoche(Coche ch) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCoche(Coche ch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, Coche> getCoche() throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void uploadMarca(Marca mc) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMarca(Marca mc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, Marca> getMarca() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMarca(Marca newMarca, Marca oldMarca) {
		// TODO Apéndice de método generado automáticamente
		
	}

}
