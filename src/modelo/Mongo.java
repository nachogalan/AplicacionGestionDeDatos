package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.Marca;

public class Mongo implements Data {

	MongoDatabase db;

	public Mongo() throws FileNotFoundException, IOException {
		Properties pr = new Properties();
		pr.load(new FileInputStream("mongo.ini"));
		MongoClient mongo = new MongoClient(pr.getProperty("server"), Integer.parseInt(pr.getProperty("port")));
		this.db = mongo.getDatabase(pr.getProperty("db"));

	}

	@Override
	public void updateCoche(Coche ch) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void uploadCoche(Coche ch) throws SQLException, IOException {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void deleteCoche(Coche ch) {
	

		MongoCollection<Document> data = db.getCollection("coches");
		FindIterable<Document> cursor = data.find();

		for (Document document : cursor) {
			if (document.getInteger("ID") == ch.getId()) {
				//document.remove();
			}else {
				System.out.println("Nacho es gei jajaja");
			}
		}

	}

	@Override
	public HashMap<Integer, Coche> getCoche() throws SQLException, FileNotFoundException {
		HashMap<Integer, Coche> result = new HashMap<Integer, Coche>();
		MongoCollection<Document> data = db.getCollection("coches");
		FindIterable<Document> cursor = data.find();
		int i = 0;
		for (Document x : cursor) {

			Document tmpMarca = (Document) x.get("Marca");
			Marca mc = new Marca(tmpMarca.getInteger("ID_Fabricante"), tmpMarca.getString("Nombre"),
					tmpMarca.getString("Sede"));
			result.put(i, new Coche(x.getInteger("ID"), x.getString("Nombre"), x.getString("Descripcion"),
					x.getString("Caracteristica1"), x.getString("Caracteristica2"), mc));
			i++;

		}
		return result;
	}

	@Override
	public void updateMarca(Marca mc) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void uploadMarca(Marca mc) throws SQLException, IOException {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void deleteMarca(Marca mc) {
		HashMap<Integer, Marca> result = new HashMap<Integer, Marca>();
		MongoCollection<Document> data = db.getCollection("marcas");
		FindIterable<Document> cursor = data.find();
	}

	@Override
	public HashMap<Integer, Marca> getMarca() throws SQLException {
		HashMap<Integer, Marca> result = new HashMap<Integer, Marca>();
		MongoCollection<Document> data = db.getCollection("marcas");
		FindIterable<Document> cursor = data.find();
		int i = 0;
		for (Document x : cursor) {
			result.put(i, new Marca(x.getInteger("ID_Fabricante"), x.getString("Nombre"), x.getString("Sede")));
			i++;
		}
		return result;
	}

}
