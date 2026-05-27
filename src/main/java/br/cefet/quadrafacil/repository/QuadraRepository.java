package br.cefet.quadrafacil.repository;

import br.cefet.quadrafacil.model.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadraRepository extends JpaRepository <Quadra, Long> {

}
