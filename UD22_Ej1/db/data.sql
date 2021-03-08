create database if not exists patronMVC_ej1;
use patronMVC_ej1;

-- table structure for table cliente

create table cliente(
id int(11) not null AUTO_INCREMENT,
nombre varchar(250) DEFAULT NULL,
apellido varchar(250) DEFAULT NULL,
direccion varchar(250) DEFAULT NULL,
dni int(11) DEFAULT NULL,
fecha date DEFAULT NULL,
PRIMARY KEY(id)
)Engine=InnoDB;

-- Dumping data for table 'cliente'

insert into `cliente` values(100, 'Robin', 'Hood', 'Notingham Forest', 1234567890, curdate()),
(101, 'Jack', 'The ripper', 'London', 1234567891, curdate()),
(102, 'Sherlock', 'Holmes', 'London perhaps', 1234567892, curdate()),
(103, 'Doctor', 'Watson', 'London shores', 1234567893, curdate()),
(104, 'Bruce', 'Wayne', 'Gotham', 1234567894, curdate());
