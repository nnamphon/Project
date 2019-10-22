package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.io.IOException;
import java.net.URLDecoder;
import  java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class ResponsibleController {
    @Autowired private ResponsibleRepository responsibleRepository;

    @GetMapping(path = "/responsible")
    private Collection<Responsible> getResponsible(){
        return this.responsibleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/responsible/")
    private Responsible newresponsibles(@RequestBody String dataDis) throws JsonParseException, IOException {

        final String decoded = URLDecoder.decode(dataDis, "UTF-8");
        dataDis = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataDis);
        JsonNode jsonName = actualObj.get("inputName");
        JsonNode jsonPartNo = actualObj.get("inputOther");


        Responsible responsible = new Responsible();
        responsible.setNameS(jsonName.textValue());
        responsible.setOther(jsonPartNo.textValue());
        return responsibleRepository.save(responsible);



    }
    
    @DeleteMapping("/responsible/{resID}")
    public void deleteResponsible(@PathVariable Long resID)
    {

        responsibleRepository.deleteById(resID);


    }


}
