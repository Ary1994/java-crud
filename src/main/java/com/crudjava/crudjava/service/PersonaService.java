
package com.crudjava.crudjava.service;

import com.crudjava.crudjava.model.Persona;
import com.crudjava.crudjava.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas=personaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePerosna(Long id) {
      personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona per = personaRepository.findById(id).orElse(null);
        return per;  
}
}