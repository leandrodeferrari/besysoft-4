package com.besysoft.bootcamp.service.impl;

import com.besysoft.bootcamp.domain.Personaje;
import com.besysoft.bootcamp.repository.database.IPersonajeRepository;
import com.besysoft.bootcamp.service.IPersonajeService;
import com.besysoft.bootcamp.util.PersonajeUtil;
import com.besysoft.bootcamp.util.ValidacionGeneralUtil;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    private final IPersonajeRepository personajeRepository;

    public PersonajeServiceImpl(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<Personaje> buscarPorFiltros(String nombre, Byte edad) {

        if(nombre == null && edad == null){
            return this.personajeRepository.findAll();
        }

        if (nombre != null && edad != null){
            return this.personajeRepository.findAllByNombreAndEdad(nombre, edad);
        }

        if(nombre != null){
            return this.personajeRepository.findAllByNombre(nombre);
        } else {
            return this.personajeRepository.findAllByEdad(edad);
        }

    }

    @Override
    public List<Personaje> buscarPorEdades(Byte desde, Byte hasta) {

        PersonajeUtil.validarEdad(desde);
        PersonajeUtil.validarEdad(hasta);
        ValidacionGeneralUtil.validarRangoDeNumeros(desde, hasta);

        return this.personajeRepository.findAllByEdadBetween(desde, hasta);

    }

    @Override
    public Personaje crear(Personaje personaje) {

        PersonajeUtil.validar(personaje);
        personaje.setId(null);

        return this.personajeRepository.save(personaje);

    }

    @Override
    public Personaje actualizar(Long id, Personaje personaje) {

        ValidacionGeneralUtil.validarId(id);
        PersonajeUtil.validar(personaje);
        personaje.setId(id);

        if(!this.personajeRepository.existsById(id)){
            throw new IllegalArgumentException("No existe personaje con ese ID.");
        }

        return this.personajeRepository.save(personaje);

    }

}
