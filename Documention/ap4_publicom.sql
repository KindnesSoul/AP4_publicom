-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 03 mai 2026 à 18:52
-- Version du serveur : 9.1.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ap4_publicom`
--

-- --------------------------------------------------------

--
-- Structure de la table `commune`
--

DROP TABLE IF EXISTS `commune`;
CREATE TABLE IF NOT EXISTS `commune` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOM` char(32) DEFAULT NULL,
  `CODEPOSTAL` bigint DEFAULT NULL,
  `DESCRIPTION` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `commune`
--

INSERT INTO `commune` (`ID`, `NOM`, `CODEPOSTAL`, `DESCRIPTION`) VALUES
(4, 'Toulouse', 31000, 'Ville Rose'),
(5, 'Lyon', 69000, 'Ville de Lyon');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_UTILISATEURCOMMUNE` int NOT NULL,
  `PRENOM` char(32) DEFAULT NULL,
  `NOM` char(32) DEFAULT NULL,
  `IDENTIFIANT` char(32) DEFAULT NULL,
  `MOTDEPASSE` char(72) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `I_FK_UTILISATEUR_COMMUNE` (`ID_UTILISATEURCOMMUNE`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `ID_UTILISATEURCOMMUNE`, `PRENOM`, `NOM`, `IDENTIFIANT`, `MOTDEPASSE`) VALUES
(17, 4, 'Julien', 'Bonnafe', 'JuBon', 'a'),
(18, 4, 'Mathieu', 'Arakelian', 'MatArak', 'a'),
(19, 5, 'Mathieu', 'Arakelian', 'MairieDeLyon', 'a');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`ID_UTILISATEURCOMMUNE`) REFERENCES `commune` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
