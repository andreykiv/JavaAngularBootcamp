
drop table if exists venta;
drop table if exists cajeros;
drop table if exists productos;
drop table if exists maquinas_registradoras;

create table cajeros(
id int auto_increment primary key,
nomapels varchar(255)
);

create table productos(
id int auto_increment primary key,
nombre varchar(255),
precio int
);

create table maquinas_registradoras(
id int auto_increment primary key,
piso int
);

create table venta(
id int auto_increment primary key,
cajero_id int not null,
producto_id int not null,
maquinas_registradoras_id int not null,
foreign key (cajero_id) references cajeros(id)
on update cascade on delete cascade,
foreign key (producto_id) references productos(id)
on update cascade on delete cascade,
foreign key (maquinas_registradoras_id) references maquinas_registradoras(id)
on update cascade on delete cascade
);

-- dumping data

insert into cajeros (nomapels) values
('Dr. Freeman'),
('Dr. Anderson'),
('Dr. Fridman'),
('Dr. Aleksanderson'),
('Dr. Bjornson');

insert into productos (nombre, precio) values
( 'Producto A', 12),
('Producto B', 124),
('Producto C', 19),
('Producto D', 21),
('Producto E', 77);

insert into maquinas_registradoras (piso) values
(2),
(1),
(3),
(2),
(4);

insert into venta (cajero_id, producto_id, maquinas_registradoras_id) values
(1, 3, 2),
(2, 2, 2),
(3, 2, 1),
(1, 3, 3),
(1, 1, 1);
