Clone the project and update as maven project.
Right click on project and run as Java application.
after that go to browser http://localhost:8080/employees/list paste this link for see the employee list here you can update and delete the employee.
For add the employee http://localhost:8080/employees/showFormForAdd paste this link.
for database setup
create database then create table using below query

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

run tghe below query to insert records.

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');

 In application. properties change the databse url, username and password with your database url,username and password.

