package modelo;

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

import org.omg.CORBA.MARSHAL;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class BBDD implements Data {

    private String bd = "abd_coches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String login = "";
    private String pwd = "";
    private String url = "jdbc:mysql://localhost/" + bd;
    private Connection conexion;
    Marca marca = new Marca(0, "", "");
    Coche coche = new Coche(0, "", "", "", "", marca);
    HashMap<String, Marca> marcaMap = new HashMap<>();
    HashMap<String, Coche> cocheMap = new HashMap<>();

    public BBDD() {

        try {
            Properties p = new Properties();
            p.load(new FileInputStream("bbdd.ini"));
            login = p.getProperty("Usuario");
            pwd = p.getProperty("Contrasena");
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, login, pwd);
            System.out.println(" - Conexión con MySQL establecida -");
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCoche(Coche ch) {

    }

    @Override
    public void uploadCoche(Coche ch) throws SQLException {

        String query = " insert into coches (Id, Nombre, Descripcion, Caracteristica1, Caracteristica2, ID_Fabricante)"
                + " values (?, ?, ?, ?, ?, ?)";

        int r = 0;

        PreparedStatement preparedStmt = conexion.prepareStatement(query);
        preparedStmt.setString(1, Integer.toString(ch.getId()));
        preparedStmt.setString(2, ch.getNombre());
        preparedStmt.setString(3, ch.getDescripcion());
        preparedStmt.setString(4, ch.getCaracteristica1());
        preparedStmt.setString(5, ch.getCaracteristica2());
        preparedStmt.setString(6, Integer.toString(ch.getMarca().getId_fabricante()));


            r = preparedStmt.executeUpdate();

    }

    @Override
    public void deleteCoche(Coche ch) {

    }

    @Override
    public HashMap<Integer, Coche> getCoche() throws SQLException {

        HashMap<Integer, Coche> listaCoches = new HashMap<Integer, Coche>();

        String Query = "SELECT * FROM coches";
        PreparedStatement preparedStmt = conexion.prepareStatement(Query);
        java.sql.ResultSet resultSet;
        resultSet = preparedStmt.executeQuery(Query);

        while (resultSet.next()) {

            int id = resultSet.getInt("ID");
            String nombre = resultSet.getString("Nombre");
            String descripcion = resultSet.getString("Descripcion");
            String caracteristica1 = resultSet.getString("Caracteristica1");
            String caracteristica2 = resultSet.getString("Caracteristica2");
            String id_Fabricante = resultSet.getString("ID_Fabricante");

            System.out.println("ID: " + " " + id + "\n" + "Nombre: " + " "
                    + nombre + "\n" + "Descripcion" + " "
                    + descripcion + "\n" + "Caracteristica1: " + " "
                    + caracteristica1 + "\n" + "Caracteristica2: " + " "
                    + caracteristica2 + "\n" + "\n" + "Fabricante: " + " "
                    + id_Fabricante + "\n");
            
            coche.setId(id);
            coche.setNombre(nombre);
            coche.setDescripcion(descripcion);
            coche.setCaracteristica1(caracteristica1);
            coche.setCaracteristica2(caracteristica2);
            coche.setMarca(marca);

            listaCoches.put(id,coche);
        }

        return listaCoches;
    }



    @Override
    public void updateMarca(Marca mc) {

    }

    @Override
    public void uploadMarca(Marca mc) throws SQLException {

        String query = " insert into marca (ID_Fabricante, Nombre, Sede)" + " values (?, ?, ?)";

        int r = 0;

        PreparedStatement preparedStmt2 = conexion.prepareStatement(query);
        preparedStmt2.setString(1, Integer.toString(marca.getId_fabricante()));
        preparedStmt2.setString(2, marca.getNombre());
        preparedStmt2.setString(3, marca.getSede());

        r = preparedStmt2.executeUpdate();

    }

    @Override
    public void deleteMarca(Marca mc) {

    }

    @Override
    public HashMap<Integer, Marca> getMarca() throws SQLException {

        HashMap<Integer, Marca> listaMarcas = new HashMap<Integer, Marca>();

        String Query = "SELECT * FROM marcas";
        PreparedStatement preparedStmt = conexion.prepareStatement(Query);
        java.sql.ResultSet resultSet;
        resultSet = preparedStmt.executeQuery(Query);


        while (resultSet.next()) {
            String id = resultSet.getString("ID_Fabricante");
            String nombre = resultSet.getString("Nombre");
            String sede = resultSet.getString("Sede");

            System.out.println("ID Fabricante: " + " " + id + "\n" + "Nombre: "
                    + " " + nombre + "\n" + "Sede: " + " " + sede
                    + "\n");

            marca.setId_fabricante(Integer.parseInt(id));
            marca.setNombre(nombre);
            marca.setSede(sede);

            listaMarcas.put(Integer.parseInt(id), marca);
        }

        return listaMarcas;
    }
}
