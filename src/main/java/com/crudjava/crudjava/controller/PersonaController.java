
package com.crudjava.crudjava.controller;

import com.crudjava.crudjava.model.Persona;
import com.crudjava.crudjava.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    @GetMapping("/personas/traer")
    public List <Persona> getPersona(){
        return interPersona.getPersonas();
    }
    @PostMapping ("/personas/crear")
    public String createStudent(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return"Se guardo satisfactoriamente";
    }
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        interPersona.deletePerosna(id);
        return "Se elimino correctamente";
    }
    @PutMapping ("/personas/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                @RequestParam ("nombre")String nuevoNombre,
                                @RequestParam("apellido")String nuevoApellido,
                                @RequestParam("edad")int nuevaEdad){
        Persona perso=interPersona.findPersona(id);
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setEdad(nuevaEdad);
        interPersona.savePersona(perso);
        return perso;
    }
}
