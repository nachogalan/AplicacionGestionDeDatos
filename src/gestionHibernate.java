import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.login.Configuration;

import org.hibernate.Query;
import org.hibernate.Session;


import org.hibernate.Query;
import org.hibernate.Session;


import java.util.Iterator;
import java.util.List;

public class gestionHibernate implements InterfazBBDD {
	
	Session session;
	int ID;
	String nombre;
    String descripcion;
    String caracteristica1;
    String caracteristica2;
    Marca marca;

	@Override
	public void Leer() throws SQLException, FileNotFoundException {
		
	}

	@Override
	public void Escribir() throws SQLException {
		
		
	}

	@Override
	public void TXTABBDD() throws FileNotFoundException, SQLException {
		
	}

	@Override
	public void BBDDTXT() throws SQLException, IOException {
		
	}

	@Override
	public void Actualizar() throws SQLException {
		
	}

	@Override
	public void Borrar() throws SQLException {
		
	}

}
