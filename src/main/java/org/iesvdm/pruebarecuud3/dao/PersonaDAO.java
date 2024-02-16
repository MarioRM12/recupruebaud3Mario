package org.iesvdm.pruebarecuud3.dao;

import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.iesvdm.pruebarecuud3.modelo.Profesor;

import java.util.List;

public interface PersonaDAO {

    public void create(Persona persona);

    public List<Persona> getAll();

}
