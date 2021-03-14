drop table if exists asignado_a;
drop table if exists cientificos;
drop table if exists proyecto;


create table cientificos(
dni varchar(8) primary key,
nomapels varchar(255)
);

create table proyecto(
id char(4) primary key,
nombre varchar(255),
horas int
);

create table asignado_a(
id int auto_increment primary key,
cientifico_dni varchar(8) not null,
proyecto_id char(4) not null,
foreign key (cientifico_dni) references cientificos(dni)
on update cascade on delete cascade,
foreign key (proyecto_id) references proyecto(id)
on update cascade on delete cascade
);

-- dumping data

insert into cientificos (dni, nomapels) values
('1234567A', 'Dr. Freeman'),
('1234567B', 'Dr. Anderson'),
('1234567C', 'Dr. Fridman'),
('1234567D', 'Dr. Aleksanderson'),
('1234567E', 'Dr. Bjornson');

insert into proyecto (id, nombre, horas) values
('123A', 'Proyecto A', 12),
('123B', 'Proyecto B', 2),
('123C', 'Proyecto C', 5),
('123D', 'Proyecto D', 7),
('123E', 'Proyecto E', 9);

insert into asignado_a (cientifico_dni, proyecto_id) values
('1234567A', '123A'),
('1234567B', '123B'),
('1234567B', '123C'),
('1234567C', '123D'),
('1234567E', '123D');