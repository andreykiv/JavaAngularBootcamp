create database if not exists patronMVC_ej2;
use patronMVC_ej2;


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

CREATE TABLE `videos` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`title` varchar(250) DEFAULT NULL,
`director` varchar(250) DEFAULT NULL,
`cli_id` int(11) DEFAULT NULL,
PRIMARY KEY(`id`),
CONSTRAINT `videos_fk` FOREIGN KEY (`cli_id`) REFERENCES `cliente` (`id`)
);

-- Dumping data for table 'cliente'

insert into `cliente` values(100, 'Robin', 'Hood', 'Notingham Forest', 1234567890, curdate()),
(101, 'Jack', 'The ripper', 'London', 1234567891, curdate()),
(102, 'Sherlock', 'Holmes', 'London perhaps', 1234567892, curdate()),
(103, 'Doctor', 'Watson', 'London shores', 1234567893, curdate()),
(104, 'Bruce', 'Wayne', 'Gotham', 1234567894, curdate());

-- Dumping data for table 'videos'

insert into `videos` values(1, 'Robin Hood', 'James Cameron', 100),
(2, 'Freddy Kruger', 'James Franco ', 100),
(3, 'The island', 'Bob Williams', 102),
(4, 'Mystery on the lake', 'Director name', 104),
(5, 'Harry Potter', 'Name Director', 104);
