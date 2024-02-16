package org.iesvdm.pruebarecuud3.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebarecuud3.modelo.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@Repository
public class DepartamentoDAOimpl implements DepartamentoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(Departamento departamento) {

        String sqlInsert = """
							INSERT INTO departamento (nombre)
							VALUES  (     ?)
						   """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rows = jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
                    int idx = 1;
                    ps.setString(idx++, departamento.getNombre());
                    return ps;
                },keyHolder);

        departamento.setId(keyHolder.getKey().intValue());

        log.info("Insertados {} registros.", rows);

    }

    @Override
    public List<Departamento> getAll() {

        List<Departamento> listDep = jdbcTemplate.query(
                "SELECT * FROM departamento",
                (rs, rowNum) -> new Departamento(rs.getInt("id"),
                        rs.getString("nombre"))
        );

        log.info("Devueltos {} registros.", listDep.size());

        return listDep;
    }
}
