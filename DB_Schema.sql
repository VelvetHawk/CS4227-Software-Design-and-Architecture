-- For: MySQL

SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Restaurant_DB`
--

-- --------------------------------------------------------

DROP DATABASE IF EXISTS `Restaurant_DB`;
CREATE DATABASE `Restaurant_DB` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE `Restaurant_DB`;

-- --------------------------------------------------------

--
-- Table structure for table `Stock`
--

DROP TABLE IF EXISTS `Stock`;
CREATE TABLE `Stock` (
	`Stock_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(100) NOT NULL,
	`Quantity` INT NOT NULL DEFAULT 0
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Account_Type`
--

DROP TABLE IF EXISTS `Account_Type`;
CREATE TABLE `Account_Type` (
	`Account_type_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

-- NOTE: Default account type is CUSTOMER (ID: 1)
DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
	`User_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50) NOT NULL,
	`Surname` VARCHAR(50) NOT NULL,
	`Username` VARCHAR(50) NOT NULL,
	`Password` varchar(255) NOT NULL,
	`Email` VARCHAR(100) NOT NULL,
	`Address` VARCHAR(255) NOT NULL,
	`Phone` VARCHAR(20) NOT NULL,
	`Points` INT UNSIGNED NOT NULL DEFAULT 0,
	`Account_type_ID` INT UNSIGNED NOT NULL DEFAULT 1,
	`Date_created` DATETIME NOT NULL DEFAULT NOW(),
	`Last_login` DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY(`Account_type_ID`) REFERENCES `Account_Type`(`Account_type_ID`)
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Consumable_type`
--

DROP TABLE IF EXISTS `Consumable_type`;
CREATE TABLE `Consumable_type` (
	`Consumable_type_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Consumables`
--

DROP TABLE IF EXISTS `Consumables`;
CREATE TABLE `Consumables` (
	`Consumable_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`Name` VARCHAR(50) NOT NULL,
	`Consumable_type_ID` INT UNSIGNED NOT NULL,
	`Base_price` DECIMAL(5,2) NOT NULL DEFAULT 0,
	FOREIGN KEY(`Consumable_type_ID`) REFERENCES `Consumable_type`(`Consumable_type_ID`)
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Size`
--

DROP TABLE IF EXISTS `Size`;
CREATE TABLE `Size` (
	`Size_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`Size` VARCHAR(50) NOT NULL,
	`Price_multiplier` DECIMAL(3,2) NOT NULL
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
CREATE TABLE `Orders` (
	`Order_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`User_ID` INT UNSIGNED NOT NULL,
	`Date_created` DATETIME NOT NULL DEFAULT NOW(),
	`Cost` DECIMAL(10,2) NOT NULL DEFAULT 1.00,
	FOREIGN KEY(`User_ID`) REFERENCES `Users`(`User_ID`)
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Order_contents`
--

-- NOTE: Default consumable size is REGULAR (ID: 2)
DROP TABLE IF EXISTS `Order_contents`;
CREATE TABLE `Order_contents` (
	`Content_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`Order_ID` INT UNSIGNED NOT NULL,
	`Consumable_ID` INT UNSIGNED NOT NULL,
	`Size_ID` INT UNSIGNED NOT NULL DEFAULT 2,
	FOREIGN KEY(`Order_ID`) REFERENCES `Orders`(`Order_ID`),
	FOREIGN KEY(`Consumable_ID`) REFERENCES `Consumables`(`Consumable_ID`),
	FOREIGN KEY(`Size_ID`) REFERENCES `Size`(`Size_ID`)
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `Reviews`
--

DROP TABLE IF EXISTS `Reviews`;
CREATE TABLE `Reviews` (
	`Review_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`User_ID` INT UNSIGNED NOT NULL,
	`Title` VARCHAR(100) NOT NULL,
	`Content` TEXT NOT NULL,
	FOREIGN KEY(`User_ID`) REFERENCES `Users`(`User_ID`)
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Default SQL Values
--

-- Default Account

CREATE USER 'sqluser' IDENTIFIED BY 'sqlpw';
GRANT ALL ON *.* to 'sqluser'@localhost IDENTIFIED BY 'sqlpw';
GRANT ALL ON *.* to 'sqluser'@'%' IDENTIFIED BY 'sqlpw';

-- Default Account types

INSERT INTO `Account_Type` (`Name`) VALUES ("CUSTOMER");
INSERT INTO `Account_Type` (`Name`) VALUES ("EMPLOYEE");
INSERT INTO `Account_Type` (`Name`) VALUES ("MANAGER");

-- Default Consumable types

INSERT INTO `Consumable_type` (`Name`) VALUES ("FOOD");
INSERT INTO `Consumable_type` (`Name`) VALUES ("TOPPING");
INSERT INTO `Consumable_type` (`Name`) VALUES ("DRINK");
INSERT INTO `Consumable_type` (`Name`) VALUES ("SIDE");

-- Default Size types

INSERT INTO `Size` (`Size`, `Price_multiplier`) VALUES ("SMALL", 0.80);
INSERT INTO `Size` (`Size`, `Price_multiplier`) VALUES ("REGULAR", 1.00);
INSERT INTO `Size` (`Size`, `Price_multiplier`) VALUES ("LARGE", 1.25);

-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
