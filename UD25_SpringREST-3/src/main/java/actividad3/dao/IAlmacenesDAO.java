package actividad3.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import actividad3.dto.Almacenes;

public interface IAlmacenesDAO extends JpaRepository<Almacenes, Long>{

}

