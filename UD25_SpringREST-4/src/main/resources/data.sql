
DROP TABLE IF EXISTS peliculas;
DROP TABLE IF EXISTS salas;

create table peliculas (
id int auto_increment,
nombre varchar(100),
calificacionedad int,
primary key (id)
);

CREATE TABLE salas(
    id int auto_increment PRIMARY KEY,
    nombre varchar(100) not null,
    pelicula int,
    FOREIGN KEY (pelicula) REFERENCES peliculas(id)
    on update cascade
    on delete cascade
);


INSERT INTO peliculas (nombre, calificacionedad) VALUES
('Batman Begins', 12),
('Superman vs Batman', 6),
('Matrix', 16),
('Matrix II', 16),
('Lord of the Rings', 12);


INSERT INTO salas (nombre, pelicula) VALUES('Rubin', 2),
('Rubin', 2),
('Topaz', 1),
('Quartz', 3),
('Copper', 4),
('Iron', 5);
