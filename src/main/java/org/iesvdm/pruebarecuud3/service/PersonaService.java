package org.iesvdm.pruebarecuud3.service;

import org.iesvdm.pruebarecuud3.dao.PersonaDAO;
import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private PersonaDAO personaDAO;

    public PersonaService(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public List<Persona> listAll() {

        return personaDAO.getAll();

    }

    public List<Persona> listAllProfesores() {

        List<Persona> listAllProfesores = personaDAO.getAll().stream()
                .filter(persona -> persona.getTipo().equals("catedratico")||persona.getTipo().equals("profesor"))
                .toList();

        return listAllProfesores();
    }

    public void newpersona(Persona persona) {

        personaDAO.create(persona);

    }

}
