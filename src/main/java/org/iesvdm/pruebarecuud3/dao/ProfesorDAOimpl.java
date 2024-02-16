package org.iesvdm.pruebarecuud3.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebarecuud3.modelo.Departamento;
import org.iesvdm.pruebarecuud3.modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ProfesorDAOimpl implements ProfesorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Profesor profesor) {

    }

    @Override
    public List<Profesor> getAll() {

        List<Profesor> listPro = jdbcTemplate.query(
                "SELECT * FROM profesor",
                (rs, rowNum) -> new Profesor(rs.getInt("id_profesor"),
                        rs.getLong("id_departamento")));

        log.info("Devueltos {} registros.", listPro.size());

        return listPro;
    }
}
