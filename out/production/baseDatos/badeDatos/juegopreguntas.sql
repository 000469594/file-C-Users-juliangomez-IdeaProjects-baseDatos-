-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-12-2021 a las 01:22:39
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juegopreguntas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `Id_categoria` int(11) NOT NULL,
  `nivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`Id_categoria`, `nivel`) VALUES
(22, 1),
(23, 2),
(24, 3),
(25, 4),
(26, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id_jugador` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `puntos` int(11) NOT NULL,
  `estado_finalizado` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id_jugador`, `nombre`, `puntos`, `estado_finalizado`) VALUES
(2, 'bryan', 10, 'perdedor'),
(3, 'estefan', 10, 'retirado'),
(4, 'tales', 0, 'perdedor'),
(5, 'este', 20, 'retirado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `id_pregunta` int(11) NOT NULL,
  `fk_categoria` int(11) NOT NULL,
  `pregunta` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`id_pregunta`, `fk_categoria`, `pregunta`) VALUES
(19, 22, 'que es el sol'),
(20, 23, 'que es java'),
(21, 24, 'que es python'),
(22, 25, 'una bebida'),
(25, 22, '¿cuanto es 2 + 2 ?'),
(26, 22, '¿cual es la capital de colombia?'),
(27, 22, '¿de que color es el cielo?'),
(28, 22, '¿que tipo de animal es el elefante?'),
(29, 23, '¿cual es la raiz cuadrada de 49?'),
(30, 23, '¿cual es la capital de portugal?'),
(31, 23, 'los seres humanos son:'),
(32, 23, '¿cuantos tentaculos tiene  un pulpo?'),
(34, 22, 'que es python');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `id_respuesta` int(11) NOT NULL,
  `fk_pregunta` int(11) NOT NULL,
  `respuesta` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `es_verdadera` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`id_respuesta`, `fk_pregunta`, `respuesta`, `es_verdadera`) VALUES
(1, 19, 'nada', 0),
(2, 19, 'una estrella', 1),
(3, 19, 'un planeta', 0),
(4, 19, 'una galaxia', 0),
(5, 19, 'un pais', 0),
(6, 20, 'marca de ropa', 0),
(7, 20, 'lenguaje', 1),
(8, 20, 'una comida', 0),
(9, 20, 'una salsa', 0),
(10, 20, 'una marca', 0),
(11, 21, 'una serpiente', 0),
(12, 21, 'un lenguaje', 1),
(13, 21, 'un pan', 0),
(14, 21, 'una sopa', 0),
(15, 21, 'un espejo', 0),
(16, 22, 'se compra', 1),
(17, 22, 'se vende', 0),
(18, 22, 'se alquila', 0),
(19, 22, 'se presta', 0),
(20, 22, 'se plancha', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`Id_categoria`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id_jugador`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`id_pregunta`),
  ADD KEY `fk_categoria_pregunta` (`fk_categoria`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`id_respuesta`),
  ADD KEY `fk_pregunta_respuesta` (`fk_pregunta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `Id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id_jugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `id_pregunta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `id_respuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `fk_categoria_pregunta` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`Id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD CONSTRAINT `fk_pregunta_respuesta` FOREIGN KEY (`fk_pregunta`) REFERENCES `pregunta` (`id_pregunta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
