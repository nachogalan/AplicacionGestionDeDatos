package modelo;

import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;


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
public class Hibernate implements Data {

	private Session	s = new Configuration().configure("/Hibernate/hibernate.cfg.xml").buildSessionFactory().openSession();
	
	private void beginTransaction() {
		if(s.getTransaction().getStatus()!=TransactionStatus.ACTIVE) {
		s.beginTransaction();
		}
	}
	
	
	@Override
	public void updateCoche(Coche ch) {
		this.beginTransaction();
		s.update(ch);
	}

	@Override
	public void uploadCoche(Coche ch) {
		this.beginTransaction();
		s.save(ch);
	}

	@Override
	public void deleteCoche(Coche ch) {
		this.beginTransaction();
		s.delete(ch);
	}

	@Override
	public HashMap<Integer, Coche> getCoche() {
		this.beginTransaction();
		HashMap<Integer, Coche> result = new HashMap<Integer, Coche>();
		Query q = s.createQuery("Select e from Coche e");
		
		@SuppressWarnings("unchecked")
		Iterator<Coche> datos = q.list().iterator();
		
		int i = 0;
		while (datos.hasNext()) {
			result.put(i, datos.next());
			i++;
		}
		return result;
	}

	@Override
	public void updateMarca(Marca marca, Marca oldMarca) {
		this.beginTransaction();
		s.update(marca);
	}

	@Override
	public void uploadMarca(Marca mc) {
		this.beginTransaction();
		s.save(mc);
	}

	@Override
	public void deleteMarca(Marca mc) {
		this.beginTransaction();
		s.delete(mc);
	}

	@Override
	public HashMap<Integer, Marca> getMarca() {
		this.beginTransaction();
		HashMap<Integer, Marca> result = new HashMap<Integer, Marca>();
		Query q = s.createQuery("Select e from Marca e");
		
		@SuppressWarnings("unchecked")
		Iterator<Marca> datos = q.list().iterator();
		
		int i = 0;
		while (datos.hasNext()) {
			result.put(i, datos.next());
			i++;
		}
		return result;
	}

}
