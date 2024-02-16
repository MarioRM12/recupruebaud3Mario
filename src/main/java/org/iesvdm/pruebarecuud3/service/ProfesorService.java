package org.iesvdm.pruebarecuud3.service;

import org.iesvdm.pruebarecuud3.dao.ProfesorDAO;
import org.iesvdm.pruebarecuud3.modelo.Profesor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private ProfesorDAO profesorDAO;

    public ProfesorService(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    public List<Profesor> listAll() {

        return profesorDAO.getAll();

    }


}
