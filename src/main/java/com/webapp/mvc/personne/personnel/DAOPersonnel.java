package com.webapp.mvc.personne.personnel;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOPersonnel {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Personnel> rowMapper = (rs, rowNum) -> {
        Personnel personnel = new Personnel(); // Il faut modifier le constructeur de peronnel pour qu'il ne prenne aucun paramètre
        personnel.setId(rs.getInt("id"));
        personnel.setLast_name(rs.getString("nom"));
        personnel.setFirst_name(rs.getString("prenom"));
        return personnel;
    };
    

    public List<Personnel> findAll() {
        String sql = "SELECT * FROM personne";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Personnel findById(int id) {
        String sql = "SELECT * FROM personne WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public int save(Personnel personne) {
        String sql = "INSERT INTO personne (nom, prenom) VALUES (?, ?)";
        return jdbcTemplate.update(sql, personne.getLast_name(), personne.getFirst_name());
    }

    public int update(Personnel personne) {
        String sql = "UPDATE personne SET nom = ?, prenom = ? WHERE id = ?";
        return jdbcTemplate.update(sql, personne.getLast_name(), personne.getFirst_name(), personne.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM personne WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
