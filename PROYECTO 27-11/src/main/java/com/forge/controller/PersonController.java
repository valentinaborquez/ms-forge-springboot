package com.forge.controller;

import com.forge.imp.PersonImp;
import com.forge.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    PersonImp iPersonImp;

    @RequestMapping(method = RequestMethod.POST)
    public Person saveUser(@RequestBody Person person)
    {
        Person personLocal = new Person();
        try{
                if(null == person.getId()){
                    personLocal = iPersonImp.save(person);
                }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return personLocal;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/name")
    public List<Person> findByName(@RequestParam String nombre)
    {
        List<Person> personLocal = new ArrayList<>();
        try{
                personLocal = iPersonImp.findByNombre(nombre);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return personLocal;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getUserAll()
    {
        List<Person> personLocal = new ArrayList<>();
        try{
             personLocal = iPersonImp.findAll();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return personLocal;
    }
}
