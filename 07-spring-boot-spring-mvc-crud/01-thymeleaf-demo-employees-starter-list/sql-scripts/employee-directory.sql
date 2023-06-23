CREATE DATABASE  IF NOT EXISTS `customer_directory`;
USE `customer_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `customer`;

CREATE TABLE customer (
  id INT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  balance DECIMAL(10,2)
);

--
-- Data for table `employee`
--
INSERT INTO customer (id, first_name, last_name, email, balance)
VALUES
  (1, 'John', 'Smith', 'john.smith@example.com', 1000.00),
  (2, 'Emma', 'Johnson', 'emma.johnson@example.com', 1500.00),
  (3, 'Michael', 'Williams', 'michael.williams@example.com', 2000.00),
  (4, 'Sophia', 'Brown', 'sophia.brown@example.com', 1200.50),
  (5, 'Daniel', 'Davis', 'daniel.davis@example.com', 3000.00),
  (6, 'Olivia', 'Miller', 'olivia.miller@example.com', 1800.75),
  (7, 'James', 'Anderson', 'james.anderson@example.com', 2500.25),
  (8, 'Ava', 'Martinez', 'ava.martinez@example.com', 1400.50),
  (9, 'William', 'Harris', 'william.harris@example.com', 3200.00),
  (10, 'Isabella', 'Garcia', 'isabella.garcia@example.com', 2100.25),
  (11, 'Liam', 'Rodriguez', 'liam.rodriguez@example.com', 1750.00),
  (12, 'Mia', 'Lopez', 'mia.lopez@example.com', 2800.75);
	(5,'Juan','Vega','juan@luv2code.com');

