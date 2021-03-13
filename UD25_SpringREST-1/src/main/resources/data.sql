DROP TABLE IF EXISTS articulos;
DROP TABLE IF EXISTS fabricantes;


create table fabricantes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(100) not null
);

create table articulos (
id INT auto_increment primary key,
nombre varchar(100) not null,
precio int not null,
fabricante int not null,
foreign key(fabricante)
references fabricantes(id)
on update cascade
on delete cascade
);


insert into fabricantes (nombre)values
('Sony'),
('Philips'),
('Xiaomi'),
('Acer'),
('AOC');

insert into articulos (nombre, precio, fabricante) values
('Monitor', 200, 1),
('Cable USB', 25, 2),
('Iphone X', 1299, 4),
('PC', 799, 5),
('Playstation 5', 599, 1);





