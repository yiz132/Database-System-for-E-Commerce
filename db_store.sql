-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2019 at 11:50 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_businesscustomer`
--

CREATE TABLE IF NOT EXISTS `tbl_businesscustomer` (
  `C_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `account` int(255) NOT NULL,
  `businessCategory` varchar(255) NOT NULL,
  `companyGross` varchar(255) NOT NULL,
  PRIMARY KEY (`C_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_homecustomer`
--

CREATE TABLE IF NOT EXISTS `tbl_homecustomer` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `account` int(255) NOT NULL,
  `age` int(255) NOT NULL,
  `marriage status` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `income` int(255) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product`
--

CREATE TABLE IF NOT EXISTS `tbl_product` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` float(10,2) NOT NULL,
  `category` varchar(255) NOT NULL,
  `inventory` int(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_region`
--

CREATE TABLE IF NOT EXISTS `tbl_region` (
  `	Region_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `manager` varchar(255) NOT NULL,
  PRIMARY KEY (`	Region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_salesperson`
--

CREATE TABLE IF NOT EXISTS `tbl_salesperson` (
  `	p_id` int(255) NOT NULL,
  `Sp_id` int(11) NOT NULL AUTO_INCREMENT,
  `salary` int(255) NOT NULL,
  `jobTitle` varchar(255) NOT NULL,
  `Store_id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `E-mail` varchar(255) NOT NULL,
  PRIMARY KEY (`Sp_id`),
  KEY `Store_id` (`Store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_store`
--

CREATE TABLE IF NOT EXISTS `tbl_store` (
  `Store_id` int(255) NOT NULL AUTO_INCREMENT,
  `num_Salespersons` int(255) NOT NULL,
  `Region_id` int(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `manager` varchar(255) NOT NULL,
  PRIMARY KEY (`Store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transact`
--

CREATE TABLE IF NOT EXISTS `tbl_transact` (
  `T_id` int(255) NOT NULL AUTO_INCREMENT,
  `	C_id` int(255) NOT NULL,
  `p_id` int(255) NOT NULL,
  `number` int(255) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`T_id`),
  KEY `p_id` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_salesperson`
--
ALTER TABLE `tbl_salesperson`
  ADD CONSTRAINT `tbl_salesperson_ibfk_1` FOREIGN KEY (`Store_id`) REFERENCES `tbl_store` (`Store_id`);

--
-- Constraints for table `tbl_transact`
--
ALTER TABLE `tbl_transact`
  ADD CONSTRAINT `tbl_transact_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `tbl_product` (`p_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
