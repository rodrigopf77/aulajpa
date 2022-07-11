package br.com.rodrigofernandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.rodrigofernandes.model.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long>{

}
