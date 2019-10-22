package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllrtAll {
    @Autowired
    private AddpointRepository addpointRepository;
    @Autowired  private MoldRepository moldRepository;
    @Autowired  private PointRepository pointRepository;
    @Autowired  private ResponsibleRepository responsibleRepository;

    //======================================================================================================================
    @GetMapping(path = "/addpoint")
    private Collection<Addpoint> getAddpoint(){
        return this.addpointRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/point")
    private Collection<Point>getPoint() {
        return this.pointRepository.findAll().stream().collect(Collectors.toList());
    }
    //======================================================================================================================
    @PostMapping(path = "/point")
    public Point point(@Valid @RequestBody Point point){

        return pointRepository.save(point);
   
    }

    //=============================================== GetMap ===============================
  
    @DeleteMapping("/point/{id}")
    public void deletePoint(@PathVariable Long id)
    {
        pointRepository.deleteById(id);
    }


}
