package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PartNameController {

    @Autowired
    private MoldRepository moldRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private final PartNameRepository partNameRepository;

    PartNameController(PartNameRepository partNameRepository) {
        this.partNameRepository = partNameRepository;
    }

    @GetMapping(path = "/partName")
    private Collection<PartName> Records(){
        return this.partNameRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/partName")
    private PartName newPartName(@RequestBody PartName newPartName, @PathVariable Long partNameID, @PathVariable String disease, @PathVariable String namepa, @PathVariable String program, @PathVariable Integer payment) {

        PartName newPartNames = new PartName();

        newPartNames.setNamePa(namepa);
        newPartNames.setPartNameID(partNameID);

            return partNameRepository.save(newPartNames);
        }
}


