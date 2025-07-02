package sn.esmt.demo2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esmt.demo2025.domain.Voiture;

public interface VoitureRepositoryJpa extends JpaRepository<Voiture,Long>{

}
