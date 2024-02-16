package org.iesvdm.pruebarecuud3.dao;

import org.iesvdm.pruebarecuud3.modelo.Departamento;
import org.iesvdm.pruebarecuud3.modelo.Profesor;

import java.util.List;

public interface ProfesorDAO {

    public void create(Profesor profesor);

    public List<Profesor> getAll();

}
