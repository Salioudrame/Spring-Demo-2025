package sn.esmt.demo2025.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import sn.esmt.demo2025.domain.Vehicule;
import sn.esmt.demo2025.domain.Voiture;

import java.util.List;

@Component
public class  VehiculeRepository implements IVoitureRepository{

    @Autowired
    VoitureRepositoryJpa voitureRepository;

    @Override
    public int saveVehicule(Voiture vehicule) {
        voitureRepository.save((Voiture) vehicule);
        return 0;
    }

    @Override
    public void deleteVehicule(Voiture vehicule) {
        voitureRepository.delete((Voiture) vehicule);
    }

    @Override
    public List<Voiture> getAllVehicules() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture getVehiculeById(Long id) {
        return voitureRepository.findById(id).get();
    }
}
