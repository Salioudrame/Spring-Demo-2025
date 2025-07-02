package sn.esmt.demo2025.services;

import sn.esmt.demo2025.domain.Voiture;

import java.util.List;

public interface VehiculeService {
    List<Voiture> getAllVehicules();
    Voiture getVehiculeById(Long id);
    void addVehicule(Voiture vehicule);
    void deleteVehicule(Voiture vehicule);
}
