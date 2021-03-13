package actividad2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad2.dto.Departamento;

public interface IDepartamentoDAO extends JpaRepository<Departamento, Long>{

}

