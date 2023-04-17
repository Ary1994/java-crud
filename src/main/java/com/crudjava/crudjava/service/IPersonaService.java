
package com.crudjava.crudjava.service;

import com.crudjava.crudjava.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List <Persona> getPersonas();
    public void savePersona(Persona persona);
    public void deletePerosna(Long id);
    public Persona findPersona(Long id);
}
