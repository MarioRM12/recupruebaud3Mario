package org.iesvdm.pruebarecuud3.controlador;

import jakarta.validation.Valid;
import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.iesvdm.pruebarecuud3.modelo.Profesor;
import org.iesvdm.pruebarecuud3.service.PersonaService;
import org.iesvdm.pruebarecuud3.service.ProfesorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ProfesorController {

    private ProfesorService profesorService;
    private PersonaService personaService;


    public ProfesorController(ProfesorService profesorService, PersonaService personaService){
        this.profesorService = profesorService;
        this.personaService = personaService;
    }

    @GetMapping("/profesores")
    public String listar(Model model) {

        List<Persona> listaProfesores =  personaService.listAllProfesores();
        model.addAttribute("listaProfesores", listaProfesores);

        return "profesores";

    }

    @GetMapping("/personas/crear")
    public String crear(Model model) {

        Persona persona = new Persona();
        model.addAttribute("persona", persona);

        return "crearpersona";

    }

    @PostMapping("/personas/crear")
    public RedirectView submitCrear(@Valid @ModelAttribute("persona") Persona persona) {

        personaService.newpersona(persona);

        return new RedirectView("/profesores") ;

    }


}
