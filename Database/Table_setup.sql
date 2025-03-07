CREATE DATABASE IF NOT EXISTS is216;
USE is216;

CREATE TABLE `customer` (
	id INT NOT NULL PRIMARY KEY,
	`first name` VARCHAR(50),
    `last name` VARCHAR(50),
    username VARCHAR(50) NOT NULL UNIQUE,
    userpassword VARCHAR(50) NOT NULL
);

CREATE TABLE `employees` (
	id INT NOT NULL PRIMARY KEY,
    `first name` VARCHAR(50),
    `last name` VARCHAR(50),
    `citizen identification` CHAR(12) NOT NULL, 
    `date of birth` DATE NOT NULL,
    position VARCHAR(50) NOT NULL
);

CREATE TABLE `revenue` (
	id INT NOT NULL PRIMARY KEY,
    `revenue date` DATE,
    profit DECIMAL(10,2)
);

CREATE TABLE `work schedule` (
	`schedule date` DATE,
    `work shift` INT,
    `employee id` INT,
    
    FOREIGN KEY (`employee id`) REFERENCES employees(id)
);

CREATE TABLE product (
    id INT NOT NULL PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    `description` TEXT,
    category VARCHAR(50)
);

CREATE TABLE `promotional program` (
    id INT NOT NULL PRIMARY KEY,
    coupon VARCHAR(50) NOT NULL,
    `description` TEXT
);

CREATE TABLE `storage` (
    id INT NOT NULL PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `dateReceived` DATE NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE `invoice` (
    id INT NOT NULL PRIMARY KEY,
    `product id` INT NOT NULL,
    `invoice date` DATE NOT NULL,
    FOREIGN KEY (`product id`) REFERENCES product(id)
);

CREATE TABLE `invoice detail` (
    id INT NOT NULL,
    `product id` INT NOT NULL,
    ice FLOAT,
    sugar FLOAT,
    toping VARCHAR(100),
    quantity INT NOT NULL,
    PRIMARY KEY (id, `product id`),
    FOREIGN KEY (id) REFERENCES invoice(id),
    FOREIGN KEY (`product id`) REFERENCES product(id)
);