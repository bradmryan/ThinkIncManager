-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 14, 2016 at 05:27 AM
-- Server version: 5.5.47-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `thinkinc`
--

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `description` longtext NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id`, `name`, `description`, `startDate`, `endDate`, `isActive`) VALUES
(2, 'test2', 'SUPER TEST NUMBER 2', '2017-08-04 00:00:00', NULL, 1),
(3, 'Test3', 'SUPER TEST NUMBER 3', '2017-07-04 00:00:00', NULL, 1),
(4, 'TEST4', 'SUPER TEST NUMBER 4', '2017-08-04 00:00:00', NULL, 1),
(5, 'TEST40', 'SUPER TEST 40', '2016-12-04 00:00:00', NULL, 1),
(6, 'NEW PROJECTS', 'SUPER NEW PROJECT', '2017-07-04 00:00:00', NULL, 1),
(7, 'NEW PROJECTS', 'SUPER NEW PROJECT', '2016-12-04 00:00:00', NULL, 1),
(9, 'fdsaf', 'fdsafd', '2017-01-04 00:00:00', NULL, 1),
(10, 'fdsafdas', 'fdsafsda', '2017-01-04 00:00:00', NULL, 1),
(12, 'fdsafdsaf', 'fdsafdsaf', '2017-02-04 00:00:00', NULL, 1),
(16, 'fdsafsdaf', 'gfdsgfdhgfdhgfd', '2016-12-04 00:00:00', NULL, 1),
(17, 'fghfdhgfdh', 'hgfdhfgdhgfdh', '2017-02-04 00:00:00', NULL, 1),
(18, 'fghfdhgfdh', 'hgfdhfgdhgfdh', '2017-02-04 00:00:00', NULL, 1),
(25, 'fdsafdsaf', 'fdsafdsafdsa', '2017-02-04 00:00:00', NULL, 1),
(26, 'fdsafdsaf', 'fdsafdsafdsa', '2017-02-04 00:00:00', NULL, 1),
(27, 'TEST PROJECT 1', 'TEST PROJECT DESCRIPTION', '2016-04-10 00:00:00', NULL, 1),
(28, 'TEST PROJECT 1', 'TEST PROJECT DESCRIPTION', '2016-04-10 00:00:00', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE IF NOT EXISTS `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `start_date` datetime NOT NULL,
  `due_date` datetime NOT NULL,
  `close_date` datetime DEFAULT NULL,
  `priority` varchar(15) NOT NULL,
  `level` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `is_open` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`id`, `description`, `start_date`, `due_date`, `close_date`, `priority`, `level`, `project_id`, `is_open`) VALUES
(10, 'TEST TICKET 1', '2016-04-08 00:00:00', '2017-04-08 00:00:00', NULL, 'HIGH', 1, 28, 1),
(11, 'TEST TICKET 1', '2016-04-08 00:00:00', '2017-04-08 00:00:00', NULL, 'HIGH', 1, 28, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `password` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `firstName`, `lastName`, `phoneNumber`, `password`) VALUES
(1, 'brad.m.ryan@gmail.com', 'brad', 'ryan', '5935555555', '6F33F60886006C8CD40588E039044DB687297346'),
(8, 'bmr.alt@gmail.com', 'Brad', 'Ryan', '5555555555', '6F33F60886006C8CD40588E039044DB687297346');

-- --------------------------------------------------------

--
-- Table structure for table `user_projects`
--

CREATE TABLE IF NOT EXISTS `user_projects` (
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `is_manager` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`,`project_id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_projects`
--

INSERT INTO `user_projects` (`user_id`, `project_id`, `is_manager`) VALUES
(1, 27, 1),
(1, 28, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_tickets`
--

CREATE TABLE IF NOT EXISTS `user_tickets` (
  `user_id` int(11) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`ticket_id`),
  KEY `user_tickets_ibfk_2` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_tickets`
--

INSERT INTO `user_tickets` (`user_id`, `ticket_id`) VALUES
(1, 10),
(1, 11);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints for table `user_projects`
--
ALTER TABLE `user_projects`
  ADD CONSTRAINT `user_projects_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_projects_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_tickets`
--
ALTER TABLE `user_tickets`
  ADD CONSTRAINT `user_tickets_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_tickets_ibfk_2` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
