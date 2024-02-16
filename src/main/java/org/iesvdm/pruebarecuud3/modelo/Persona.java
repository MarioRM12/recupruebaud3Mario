package org.iesvdm.pruebarecuud3.modelo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Long id;

    @Pattern(regexp = "((([X-Z])|([LM])){1}([-]?)((\\d){7})([-]?)([A-Z]{1}))|((\\d{8})([-]?)([A-Z]))",message = "Debe cumplir con el formato requerido")
    private String nif;

    @Min(value = 3,message = "Debe ser de minimo 3 caracteres")
    @NotBlank
    private String nombre;
    private String apellido1;
    private String apellido2;


    @Max(value = 25, message = "Este campo debe tener como maximo 25 caracteres")
    private String ciudad;
    private String direccion;
    private String telefono;
    private Date fecha_nacimiento;
    private String tipo;


}
