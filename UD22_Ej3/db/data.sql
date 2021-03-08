create database patronMVC_ej3;
use patronMVC_ej3;

create table cientificos (
dni varchar(8) unique not null,
nomApels varchar(255),
primary key(dni)
)Engine=InnoDb;

create table proyecto (
id char(4) unique not null,
nombre varchar(255),
horas int,
primary key(id)
)Engine=InnoDB;


create table asignado_a (
cientifico varchar(8),
proyecto char(4),
primary key(cientifico, proyecto),
key cientifico(cientifico),
key proyecto(proyecto),
foreign key(cientifico) 
references cientificos(dni)
on delete cascade
on update cascade,
foreign key(proyecto)
references proyecto(id)
on delete cascade
on update cascade
) Engine =InnoDB;

-- hacemos dumping de db

insert into `cientificos` values("x2334590", "Hopkins"),
("x2334591", "Jenkins"),
("x2334592", "Leeroy"),
("x2334593", "Silverline"),
("x2334594", "Felwood");

insert into `proyecto` values('a134', "Proyecto1", 12),
('a234', "Proyecto2", 12),
('a334', "Proyecto3", 12),
('a434', "Proyecto4", 12),
('a534', "Proyecto5", 12);

insert into `asignado_a` values("x2334590", 'a134'),
("x2334591", 'a134'),
("x2334592", 'a234'),
("x2334593", 'a334'),
("x2334594", 'a434');







