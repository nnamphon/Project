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
class MoldController {
    @Autowired private MoldRepository moldRepository;
    @Autowired private PartNameRepository partNameRepository;
    @Autowired private ModelRepository modelRepository;
    @Autowired private ProductRepository productRepository;

    @GetMapping(path = "/mold")
    private Collection<Mold> getMold(){
        return this.moldRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/mold/{nid}/{gid}/{pid}")
    private Mold newmolds(@RequestBody String dataDis,@PathVariable Long nid, @PathVariable Long gid,
                          @PathVariable Long pid) throws JsonParseException, IOException {

        final String decoded = URLDecoder.decode(dataDis, "UTF-8");
        dataDis = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataDis);
        JsonNode jsonName = actualObj.get("inputName");
        JsonNode jsonPartNo = actualObj.get("inputPartNo");


        Mold mold = new Mold();
        mold.setNameM(jsonName.textValue());
        mold.setPartNo(jsonPartNo.textValue());
        mold.setModel(modelRepository.getOne(gid));
        mold.setPartName(partNameRepository.getOne(pid));
        mold.setProName(productRepository.getOne(nid));
        return moldRepository.save(mold);



    }
    
    @DeleteMapping("/mold/{moldID}")
    public void deleteMold(@PathVariable Long moldID)
    {

        moldRepository.deleteById(moldID);


    }

//    @GetMapping("/mold/{meid}")
//    public void customer(@PathVariable Long meid) {
//        return moldRepository.findByMeid().stream().collect(Collectors.toList());
//
//    }

//    @GetMapping("/mold/getdata/{meid}")
//    public Optional<Mold> Record(@PathVariable Long meid) {
//        Optional<Mold> V = moldRepository.findById(meid);
//        return V;
//    }

}
