<?php
require 'bbdd.php';


$arrMensaje = array();


$query = "SELECT * FROM coches";

$result = $conn->query($query);

if (isset ($result) && $result) {

    if ($result->num_rows > 0) {

        $arrCoches = array();

        while ($row = $result->fetch_assoc()) {


            $arrCoche = array();

            $arrCoche["id"] = $row["ID"];
            $arrCoche["nombre"] = $row["Nombre"];
            $arrCoche["descripcion"] = $row["Descripcion"];
            $arrCoche["caracteristica1"] = $row["Caracteristica1"];
            $arrCoche["caracteristica2"] = $row["Caracteristica2"];
            $arrCoche["idFabricante"] = $row["ID_Fabricante"];

            $arrCoches[] = $arrCoche;

        }


        $arrMensaje["estado"] = "ok";
        $arrMensaje["coches"] = $arrCoches;


    } else {

        $arrMensaje["estado"] = "ok";
        $arrMensaje["coches"] = [];
    }

} else {

    $arrMensaje["estado"] = "error";
    $arrMensaje["mensaje"] = "SE HA PRODUCIDO UN ERROR AL ACCEDER A LA BASE DE DATOS";
    $arrMensaje["error"] = $conn->error;
    $arrMensaje["query"] = $query;

}

$mensajeJSON = json_encode($arrMensaje, JSON_PRETTY_PRINT);


echo $mensajeJSON;


$conn->close();

?>
