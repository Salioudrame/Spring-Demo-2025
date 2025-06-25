package sn.esmt.demo2025.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.esmt.demo2025.domain.Vehicule;
import sn.esmt.demo2025.repositories.VehiculeRepository;

import java.util.List;

@Service
public class VoitureService implements VehiculeService{

    @Autowired
    VehiculeRepository voitureRepository;

    @Override
    public List<Vehicule> getAllVehicules() {
        return voitureRepository.getAllVehicules();
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return voitureRepository.getVehiculeById(id);
    }

    @Override
    public void addVehicule(Vehicule vehicule) {
        try {
            voitureRepository.saveVehicule(vehicule);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unable to add vehicle: " + e.getMessage());
        }
    }

    @Override
    public void deleteVehicule(Vehicule vehicule) {
        voitureRepository.deleteVehicule(vehicule);
    }
}
