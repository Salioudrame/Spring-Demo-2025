package sn.esmt.demo2025.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sn.esmt.demo2025.domain.Vehicule;
import sn.esmt.demo2025.domain.Voiture;
import sn.esmt.demo2025.repositories.IVoitureRepository;
import sn.esmt.demo2025.services.VehiculeService;

import java.util.List;

@Service
public class VoitureService implements VehiculeService {

    @Autowired
    IVoitureRepository IVoitureRepository;

    @Override
    public List<Voiture> getAllVehicules() {
        return IVoitureRepository.getAllVehicules();
    }

    @Override
    public Voiture getVehiculeById(Long id) {
        return IVoitureRepository.getVehiculeById(id);
    }

    @Override
    public void addVehicule(Voiture vehicule) {
        try {
            IVoitureRepository.saveVehicule(vehicule);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unable to add vehicle: " + e.getMessage());
        }
    }

    @Override
    public void deleteVehicule(Voiture vehicule) {
        IVoitureRepository.deleteVehicule(vehicule);
    }
}
