DROP TABLE IF EXISTS empleados;
DROP TABLE IF EXISTS departamentos;



CREATE TABLE departamentos(
    id int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100) not null,
    presupuesto int not null
);

CREATE TABLE empleados(
    dni varchar(8) PRIMARY KEY,
    nombre varchar(100) not null,
    apellidos varchar(255) not null,
    departamento int,
    FOREIGN KEY (departamento) REFERENCES departamentos(id)
    on update cascade
    on delete cascade
);


INSERT INTO departamentos (nombre, presupuesto) VALUES
('Finanzas', '25000'),
('Comercial', '32000'),
('IT', '55000'),
('Contabilidad', '7000'),
('Atención cliente', '9000');

insert into empleados (dni, nombre, apellidos, departamento) values
('2223334X', 'Michael', 'Scott', 1),
('2223334Y', 'Alex', 'Rud', 2),
('2223334Z', 'Jim', 'Harper', 3),
('2223334A', 'Amanda', 'Buff', 3),
('2223334B', 'Lisa', 'Simpson', 5);





