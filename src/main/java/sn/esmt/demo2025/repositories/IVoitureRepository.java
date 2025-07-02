package sn.esmt.demo2025.repositories;

import sn.esmt.demo2025.domain.Voiture;
import sn.esmt.demo2025.domain.Voiture;

import java.util.List;

public interface IVoitureRepository {
    int saveVehicule(Voiture voiture);
    void deleteVehicule(Voiture voiture);
    List<Voiture> getAllVehicules();
    Voiture getVehiculeById(Long id);
}
