DROP TABLE IF EXISTS cajas;
DROP TABLE IF EXISTS almacenes;

create table almacenes (
id int auto_increment,
lugar varchar(100),
capacidad int,
primary key (id)
);

CREATE TABLE cajas(
    numreferencia char(5) PRIMARY KEY,
    contenido varchar(100) not null,
    valor varchar(255) not null,
    almacen int,
    FOREIGN KEY (almacen) REFERENCES almacenes(id)
    on update cascade
    on delete cascade
);


INSERT INTO almacenes (lugar, capacidad) VALUES
('Valencia', 3),
('Barcelona', 6),
('Bilbao', 12),
('Los Angeles', 21),
('San Francisco', 11);


INSERT INTO cajas (numreferencia, contenido, valor, almacen) VALUES('0MN7','Rocks',180,3),
('4H8P','Rocks',250,1),
('4RT3','Scissors',190,4),
('7G3H','Rocks',200,1),
('8JN6','Papers',75,1),
('8Y6U','Papers',50,3),
('9J6F','Papers',175,2),
('LL08','Rocks',140,4),
('P0H6','Scissors',125,1),
('P2T6','Scissors',150,2),
('TU55','Papers',90,5);








