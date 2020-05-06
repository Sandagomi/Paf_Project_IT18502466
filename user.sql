-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: May 06, 2020 at 11:04 AM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `userAddress` varchar(30) NOT NULL,
  `contactNumber` int(11) NOT NULL,
  `userDOB` varchar(10) NOT NULL,
  `userAge` int(11) NOT NULL,
  `userEmail` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `firstName`, `lastName`, `userAddress`, `contactNumber`, `userDOB`, `userAge`, `userEmail`) VALUES
(30, 'Anna', 'karla', 'home', 123, '1997-09-12', 23, 'Hi'),
(31, 'Vanessa', 'Miha', 'Away', 123, '1997-12-1', 23, 'abc'),
(32, 'Sandagomi', 'Vihanga', 'Home', 234, '1997-09-12', 23, 'next'),
(36, 'David', 'Gandi', 'Away', 456, '1997-08-12', 23, 'dever'),
(34, 'Tommy', 'Shelby', 'Birmingham', 119, '1972-02-12', 56, 'abc'),
(35, 'Jehan', 'Morgan', 'Home', 112, '1997-09-11', 12, 'Ganray'),
(37, 'Mary', 'Jane', 'WestCoast', 123, '2020-02-12', 12, 'better');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
