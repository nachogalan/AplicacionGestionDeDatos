-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-10-2018 a las 18:38:54
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `abd_coches`
--
CREATE DATABASE IF NOT EXISTS `abd_coches` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `abd_coches`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coches`
--

CREATE TABLE `coches` (
  `ID` int(10) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Caracteristica1` varchar(190) NOT NULL,
  `Caracteristica2` varchar(190) NOT NULL,
  `ID_Fabricante` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `coches`
--

INSERT INTO `coches` (`ID`, `Nombre`, `Descripcion`, `Caracteristica1`, `Caracteristica2`, `ID_Fabricante`) VALUES
(1, 'rdsge', 'faeer', 'fewa', 'faew', 1),
(2, 'ew	g', 'AGRE', 'ARG', 'GREA', 1),
(10, 'A5', 'Bonito', 'juan', 'carños', 48);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `ID_Fabricante` int(10) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Sede` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`ID_Fabricante`, `Nombre`, `Sede`) VALUES
(1, 'Toyota', 'Japon'),
(5, 'vdwte', 'werf'),
(48, 'mercedes', 'Alemania');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `coches`
--
ALTER TABLE `coches`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Fabricante` (`ID_Fabricante`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`ID_Fabricante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `coches`
--
ALTER TABLE `coches`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `ID_Fabricante` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `coches`
--
ALTER TABLE `coches`
  ADD CONSTRAINT `coches_ibfk_1` FOREIGN KEY (`ID_Fabricante`) REFERENCES `marca` (`ID_Fabricante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
