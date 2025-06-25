package sn.esmt.demo2025.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sn.esmt.demo2025.domain.Vehicule;

import java.util.List;

@Component
public class VoitureRepository implements VehiculeRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean matriculeExists(String matricule) {
        String sql = "SELECT COUNT(*) FROM voiture WHERE matricule = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, matricule);
        return count > 0;
    }


    @Override
    public int saveVehicule(Vehicule voiture) {
        if (matriculeExists(voiture.getMatricule())) {
            throw new IllegalArgumentException("A vehicle with matricule " + voiture.getMatricule() + " already exists");
        }

        String sql = "INSERT INTO voiture (matricule, marque, modele, annee, carburant, couleur, type) VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, voiture.getMatricule(), voiture.getMarque(), voiture.getModele(), voiture.getAnnee(), voiture.getCarburant(), voiture.getCouleur(), voiture.getType() );
    }

    @Override
    public void deleteVehicule(Vehicule vehicule) {
        String sql = "DELETE FROM voiture WHERE id = ?";
        jdbcTemplate.update(sql, vehicule.getId());

    }

    @Override
    public List<Vehicule> getAllVehicules() {
        String sql = "SELECT * FROM voiture";
        List<Vehicule> voitures = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vehicule.class));
        return voitures;
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        String sql = "SELECT * FROM voiture WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Vehicule.class),
                    id
            );
        } catch (Exception e) {
            return null;
        }
    }
}
