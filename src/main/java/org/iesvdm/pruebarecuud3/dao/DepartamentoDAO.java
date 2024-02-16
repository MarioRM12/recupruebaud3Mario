package org.iesvdm.pruebarecuud3.dao;

import org.iesvdm.pruebarecuud3.modelo.Departamento;

import java.util.List;

public interface DepartamentoDAO {

    public void create(Departamento departamento);

    public List<Departamento> getAll();

}
