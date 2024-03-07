-- Active: 1700452364000@@127.0.0.1@3306@market
-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 16, 2021 at 03:34 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Market`
--

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `CatagoryID` int(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` (`CatagoryID`, `Name`, `Description`) VALUES
(1, 'Fruit', 'The kind that can be eaten without cooking'),
(2, 'Green Vegetables', 'The kind used to make salads or soups'),
(3, 'Spices', 'The kind used to enhance the taste of food');

-- --------------------------------------------------------

--
-- Table structure for table `Customers`
--

CREATE TABLE `Customers` (
  `CustomerID` int(10) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Fullname` varchar(40) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Customers`
--

INSERT INTO `Customers` (`CustomerID`, `Password`, `Fullname`, `Address`, `City`) VALUES
(1, 'Abcd1234', 'John Smith', '30 Broadway', 'London'),
(2, 'Abcd1234', 'Jonny English', '99 River View', 'Reading'),
(3, 'Abcd1234', 'Elizabeth', '23 Buckinghamshire', 'York'),
(4, 'Abcd1234', 'Beatrix', '66 Royal Crescent', 'Bath');

-- --------------------------------------------------------

--
-- Table structure for table `Order`
--

CREATE TABLE `Order` (
  `OrderID` int(10) UNSIGNED NOT NULL,
  `CustomerID` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Total` float NOT NULL,
  `Note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Order`
--

INSERT INTO `Order` (`OrderID`, `CustomerID`, `Date`, `Total`, `Note`) VALUES
(0, 1, '2021-08-15', 150000, 'Use environmental protection bags'),
(1, 2, '2021-08-16', 235000, ''),
(2, 3, '2021-08-16', 65000, 'Need fast delivery'),
(3, 3, '2021-08-17', 80000, '');

-- --------------------------------------------------------

--
-- Table structure for table `OrderDetail`
--

CREATE TABLE `OrderDetail` (
  `OrderID` int(10) UNSIGNED NOT NULL,
  `VegetableID` int(10) NOT NULL,
  `Quantity` tinyint(4) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `OrderDetail`
--

INSERT INTO `OrderDetail` (`OrderID`, `VegetableID`, `Quantity`, `Price`) VALUES
(0, 1, 1, 30000),
(0, 8, 1, 120000),
(1, 4, 1, 80000),
(1, 2, 1, 35000),
(1, 3, 1, 150000),
(2, 5, 1, 35000),
(2, 7, 2, 30000),
(3, 6, 2, 80000);

-- --------------------------------------------------------

--
-- Table structure for table `Vegetable`
--

CREATE TABLE `Vegetable` (
  `VegetableID` int(10) NOT NULL,
  `CatagoryID` int(10) NOT NULL,
  `VegetableName` varchar(30) NOT NULL,
  `Unit` varchar(20) NOT NULL,
  `Amount` int(10) NOT NULL,
  `Image` varchar(50) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Vegetable`
--

INSERT INTO `Vegetable` (`VegetableID`, `CatagoryID`, `VegetableName`, `Unit`, `Amount`, `Image`, `Price`) VALUES
(1, 1, 'Tomato', 'kg', 100, 'images/tomato.jpg', 30000),
(2, 1, 'potato', 'kg', 150, 'images/potato.jpg', 35000),
(3, 1, 'Apple', 'bag', 50, 'images/apple.jpg', 150000),
(4, 1, 'Water melon', 'per fruit', 20, 'images/watermelon.jpg', 80000),
(5, 2, ' broccoli', 'kg', 50, 'images/broccoli.jpg', 35000),
(6, 2, 'celery', 'kg', 80, 'images/celery.jpg', 40000),
(7, 3, ' spring onion', 'bunch', 50, 'images/springonion.jpg', 15000),
(8, 3, 'garlic', 'kg', 30, 'images/garlic.jpg', 120000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`CatagoryID`);

--
-- Indexes for table `Customers`
--
ALTER TABLE `Customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `Order`
--
ALTER TABLE `Order`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Indexes for table `OrderDetail`
--
ALTER TABLE `OrderDetail`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `VegetableID` (`VegetableID`);

--
-- Indexes for table `Vegetable`
--
ALTER TABLE `Vegetable`
  ADD PRIMARY KEY (`VegetableID`),
  ADD KEY `CatagoryID` (`CatagoryID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Category`
--
ALTER TABLE `Category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`CatagoryID`) REFERENCES `Vegetable` (`CatagoryID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Order`
--
ALTER TABLE `Order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `Customers` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `OrderDetail`
--
ALTER TABLE `OrderDetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`VegetableID`) REFERENCES `Vegetable` (`VegetableID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`OrderID`) REFERENCES `Order` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
