package sn.esmt.demo2025.repositories;

import sn.esmt.demo2025.domain.Vehicule;

import java.util.List;

public interface VehiculeRepository {
    int saveVehicule(Vehicule vehicule);
    void deleteVehicule(Vehicule vehicule);
    List<Vehicule> getAllVehicules();
    Vehicule getVehiculeById(Long id);
}
