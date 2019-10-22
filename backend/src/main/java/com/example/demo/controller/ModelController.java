package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ModelController {
    @Autowired private ModelRepository modelRepository;

    @Autowired
    ModelController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @GetMapping(path = "/model")
    private Collection<Model> getPatientCollection() {
        return this.modelRepository.findAll().stream().collect(Collectors.toList());
    }

    @PutMapping(path = "/model/{PaId}")
    private Model replaceModel(@RequestBody Model newModel, @PathVariable Long modelID) {
        return modelRepository.findById(modelID).map(model -> {

            model.setModel(newModel.getModel());
            return modelRepository.save(model);
        }).orElseGet(() -> {
            newModel.setModelID(modelID);
            return modelRepository.save(newModel);
        });
    }
    @PostMapping(path = "/model")
    private Model newmodel(@RequestBody Model newModel){
        return modelRepository.save(newModel);
    }
}
