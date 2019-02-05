package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import javax.management.MXBean;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.Marca;
import vista.Vista;

public class Mongo implements Data {

	MongoDatabase db;

	public Mongo() throws FileNotFoundException, IOException {
		Properties pr = new Properties();
		pr.load(new FileInputStream("mongo.ini"));
		MongoClient mongo = new MongoClient(pr.getProperty("server"), Integer.parseInt(pr.getProperty("port")));
		this.db = mongo.getDatabase(pr.getProperty("db"));

	}

	@Override
	public void updateCoche(Coche ch, Coche oldCoche) {
		Document newDocument = new Document();
		Document mcDoc = new Document();
		
		mcDoc.append("ID_Fabricante", ch.getMarca().getId_fabricante());
		newDocument.put("Nombre", ch.getMarca().getNombre());
		newDocument.put("Sede", ch.getMarca().getSede());
		
		newDocument.put("ID", ch.getId());
		newDocument.put("Nombre", ch.getNombre());
		newDocument.put("Descripcion", ch.getDescripcion());
		newDocument.put("Caracteristica1", ch.getCaracteristica1());
		newDocument.put("Caracteristica2", ch.getCaracteristica2());
		newDocument.put("Marca", mcDoc);


		Document searchQuery = new Document().append("ID", ch.getId());
		db.getCollection("marcas").updateOne(searchQuery, newDocument);
	}

	@Override
	public void uploadCoche(Coche ch) throws SQLException, IOException {
		
		
		
		MongoCollection<Document> datacoches = db.getCollection("coches");
		
				Document documentmarca = new Document();
				documentmarca.put("ID_Fabricante", ch.getMarca().getId_fabricante());
				documentmarca.put("Nombre", ch.getMarca().getNombre());
				documentmarca.put("Sede", ch.getMarca().getSede());
				
		
		
				Document documentDetail = new Document();
				documentDetail.put("ID", ch.getId());
				documentDetail.put("Nombre", ch.getNombre());
				documentDetail.put("Descripcion", ch.getDescripcion());
				documentDetail.put("Caracteristica1", ch.getCaracteristica1());
				documentDetail.put("Caracteristica2", ch.getCaracteristica2());
				documentDetail.put("Marca",documentmarca);
				datacoches.insertOne(documentDetail);
			
	}

	@Override
	public void deleteCoche(Coche ch) {
		int id = ch.getId();
		MongoCollection<Document> data = db.getCollection("coches");
		FindIterable<Document> cursor = data.find();
		System.out.println(id);
		for (Document document : cursor) {
			System.out.println("hola");
			if (document.getInteger("ID") == id) {
				Coche coche = new Coche();
				coche.setId(id);
				
				document.remove(data.findOneAndDelete(document).get(id));
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
	public void updateMarca(Marca marca, Marca oldMarca) {
		
		Document newDocument = new Document();
		newDocument.put("ID_Fabricante", marca.getId_fabricante());
		newDocument.put("Nombre", marca.getNombre());
		newDocument.put("Sede", marca.getSede());
		Document searchQuery = new Document().append("ID_Fabricante", oldMarca.getId_fabricante());
		db.getCollection("marcas").updateOne(searchQuery, newDocument);
	}

	@Override
	public void uploadMarca(Marca mc) throws SQLException, IOException {
		
		MongoCollection<Document> data = db.getCollection("marcas");
		Document documentDetail = new Document();
		documentDetail.put("ID_Fabricante", mc.getId_fabricante());
		documentDetail.put("Nombre", mc.getNombre());
		documentDetail.put("Sede", mc.getSede());
		
		data.insertOne(documentDetail);
		
		

	}

	@Override
	public void deleteMarca(Marca mc) {
		int id = mc.getId_fabricante();
		MongoCollection<Document> data = db.getCollection("marcas");
		FindIterable<Document> cursor = data.find();
		System.out.println(id);
		for (Document document : cursor) {
			System.out.println("hola");
			if (document.getInteger("ID_Fabricante") == id) {
				Marca coche = new Marca();
				coche.setId_fabricante(id);
				
				document.remove(data.findOneAndDelete(document).get(id));
			}
	}
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
