package actividad4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad4.dto.Peliculas;

public interface IPeliculasDAO extends JpaRepository<Peliculas, Long>{

}

