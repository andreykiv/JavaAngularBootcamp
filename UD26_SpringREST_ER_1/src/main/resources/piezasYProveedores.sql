
drop table if exists piezas;
drop table if exists proveedores;
drop table if exists suministra;

create table piezas(
id int auto_increment primary key,
nombre varchar(100) not null
);

create table proveedores(
id varchar(4) primary key,
nombre varchar(100)
);

create table suministra(
id int auto_increment primary key,
codigopieza_id int not null,
proveedor_id varchar(100) not null,
precio int not null,
foreign key(codigopieza_id) references piezas(id)
on update cascade on delete cascade,
foreign key(proveedor_id) references proveedores(id)
on update cascade on delete cascade);

-- dumping data
insert into piezas (nombre) values
('Guantes'),
('Martillo'),
('Clavos'),
('Alicates'),
('Baterias');

insert into proveedores (id, nombre) values 
('1', 'Makita'),
('2', 'Bosch'),
('3', 'Handyman'),
('4', 'Boogyman'),
('5', 'DIYman');

insert into suministra (codigopieza_id, proveedor_id, precio) values
(1, '3', 199),
(2, '4', 200),
(1, '1', 49),
(3, '2', 433),
(4, '5', 19);