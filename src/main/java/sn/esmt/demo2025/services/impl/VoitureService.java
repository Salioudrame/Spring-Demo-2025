package sn.esmt.demo2025.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.esmt.demo2025.domain.Vehicule;
import sn.esmt.demo2025.repositories.VehiculeRepository;
import sn.esmt.demo2025.services.VehiculeService;

import java.util.List;

@Service
public class VoitureService implements VehiculeService {

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.getAllVehicules();
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.getVehiculeById(id);
    }

    @Override
    public void addVehicule(Vehicule vehicule) {
        try {
            vehiculeRepository.saveVehicule(vehicule);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unable to add vehicle: " + e.getMessage());
        }
    }

    @Override
    public void deleteVehicule(Vehicule vehicule) {
        vehiculeRepository.deleteVehicule(vehicule);
    }
}
