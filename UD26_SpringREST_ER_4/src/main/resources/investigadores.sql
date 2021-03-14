drop table if exists reserva;
drop table if exists facultad;
drop table if exists investigadores;
drop table if exists equipos;

create table facultad(
id int auto_increment primary key,
nombre varchar(100)
);

create table investigadores(
dni varchar(8) primary key,
nomapels varchar(255),
facultad int,
foreign key(facultad) references facultad(id)
on update cascade on delete set null
);

create table equipos(
numserie char(4) primary key,
nombre varchar(100),
facultad int,
foreign key(facultad) references facultad(id)
on update cascade on delete set null
);
drop table if exists reserva;
create table reserva(
id int auto_increment primary key,
investigador_dni varchar(8) not null,
equipo_numserie char(4) not null,
comienzo datetime,
fin datetime,
foreign key (investigador_dni) references investigadores(dni)
on update cascade on delete cascade,
foreign key (equipo_numserie) references equipos(numserie)
on update cascade on delete cascade
);

-- dumping data

insert into facultad (nombre) values
('Medicina'),
('Matematicas'),
('Fisica'),
('Economia'),
('Historia');


insert into investigadores (dni, nomapels, facultad) values
( '1234567A', 'John Wick', 1),
( '1234567B', 'John Click', 2),
( '1234567C', 'John Bick', 3),
( '1234567D', 'John Tick', 2),
( '1234567E', 'John Sick', 5);

insert into equipos (numserie, nombre, facultad) values
('123A', 'Equipo A', 1),
('123B', 'Equipo B', 2),
('123C', 'Equipo C', 3),
('123D', 'Equipo D', 4),
('123E', 'Equipo E', 5);

insert into reserva (investigador_dni, equipo_numserie, comienzo, fin) values
('1234567A', '123C', now(), (now()+interval 2 hour)),
('1234567D', '123A', now(), (now()+interval 2 hour)),
('1234567C', '123D', now(), (now()+interval 2 hour)),
('1234567D', '123E', now(), (now()+interval 2 hour)),
('1234567E', '123B', now(), (now()+interval 2 hour));