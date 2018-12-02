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

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class File implements Data {

    private final String fileCoches = "coches.txt";
    Coche coche = new Coche();
    Marca marca = new Marca();

    @Override
    public void updateCoche(Coche ch) {

    }

    @Override
    public void uploadCoche(Coche ch) throws SQLException, IOException {

        int id = coche.getId();
        String nombre = coche.getNombre();
        String descripcion = coche.getDescripcion();
        String caracteristicas1 = coche.getCaracteristica1();
        String caracteristicas2 = coche.getCaracteristica2();
        String id_Fabricante = Integer.toString(coche.marca.getId_fabricante());

        FileWriter  fichero = new FileWriter(fileCoches, true);

        fichero.write(id + "\n" + nombre + "\n" + descripcion + "\n" + caracteristicas1 + "\n"
                + caracteristicas2 + "\n" + id_Fabricante + "\n");

        fichero.close();

    }


    @Override
    public void deleteCoche(Coche ch) {

    }

    @Override
    public HashMap<Integer, Coche> getCoche() throws SQLException, FileNotFoundException {

        HashMap<Integer, Coche> listaCoches = new HashMap<Integer, Coche>();

        java.io.File archivo = new java.io.File(fileCoches);
        Scanner sc = new Scanner(archivo);
        while (sc.hasNextLine()) {
            int i = 1;
            if (i == 1) {
                coche.setId(Integer.parseInt(sc.nextLine()));
                System.out.print(sc.nextLine() + "\n");
                i++;
            } else if (i == 2) {
                coche.setNombre(sc.nextLine());
                System.out.print(sc.nextLine() + "\n");
                i++;
            } else if (i == 3) {
                coche.setDescripcion(sc.nextLine());
                System.out.print(sc.nextLine() + "\n");
                i++;
            } else if (i == 4) {
                coche.setCaracteristica1(sc.nextLine());
                System.out.print(sc.nextLine() + "\n");
                i++;
            }else if (i == 5) {
                coche.setCaracteristica2(sc.nextLine());
                System.out.print(sc.nextLine() + "\n");

            }else if (i == 6) {
                coche.setMarca(marca);
                System.out.print(sc.nextLine() + "\n");
                i =1;
                listaCoches.put(coche.getId(),coche);
            }

        }
        return listaCoches;
    }

    @Override
    public void updateMarca(Marca mc) {

    }

    @Override
    public void uploadMarca(Marca mc) throws SQLException, IOException {

        String id_fabricante =Integer.toString(mc.getId_fabricante());
        String nombre = mc.getNombre();
        String sede = mc.getSede();


        FileWriter   fichero = new FileWriter("marcas.txt", true);

        fichero.write(id_fabricante + "\n" + nombre + "\n" + sede + "\n");

        fichero.close();

    }

    @Override
    public void deleteMarca(Marca mc) {

    }

    @Override
    public HashMap<Integer, Marca> getMarca() throws SQLException {
        return null;
    }
}
