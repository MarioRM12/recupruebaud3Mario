package org.iesvdm.pruebarecuud3.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@Repository
public class PersonaDAOimpl implements PersonaDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Persona persona) {

        String sqlInsert = """
							INSERT INTO persona (nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, tipo) 
							VALUES  (     ?,         ?,         ?,       ?,         ?,         ?,         ?,         ?,         ?)
						   """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rows = jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
                    int idx = 1;
                    ps.setString(idx++, persona.getNif());
                    ps.setString(idx++, persona.getNombre());
                    ps.setString(idx++, persona.getApellido1());
                    ps.setString(idx++, persona.getApellido2());
                    ps.setString(idx++, persona.getCiudad());
                    ps.setString(idx++, persona.getDireccion());
                    ps.setString(idx++, persona.getTelefono());
                    ps.setDate(idx++, (Date) persona.getFecha_nacimiento());
                    ps.setString(idx++, persona.getTipo());
                    return ps;
                },keyHolder);

        persona.setId(keyHolder.getKey().longValue());

        log.info("Insertados {} registros.", rows);

    }

    @Override
    public List<Persona> getAll() {
        List<Persona> listPer = jdbcTemplate.query(
                "SELECT * FROM persona",
                (rs, rowNum) -> new Persona(rs.getLong("id"),
                        rs.getString("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("ciudad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("tipo")
                )
        );

        log.info("Devueltos {} registros.", listPer.size());

        return listPer;
    }
}
