
DROP table IF EXISTS empleados;

create table empleados(
	id int auto_increment PRIMARY KEY,
	nombre varchar(250),
	trabajo ENUM('Software Developer', 'Accountant', 'CEO', 'Customer Service Agent', 'Business developer') not null,
	salario int
);

INSERT INTO empleados (nombre, trabajo, salario) VALUES
('John', 'Software Developer', 2500),
('Matilda', 'Accountant', 2000),
('Erik', 'CEO', 4000),
('Ezekiel', 'Customer Service Agent', 1500),
('Olena', 'Business developer', 2100);