package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Allcontroller{

    @Autowired private StaffRepository staffRepository;  
    @GetMapping(path = "/staff")
    private Collection<Staff> getStaff(){
        return this.staffRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/staff/{username}/{password}")
    public boolean admin(@PathVariable String username, @PathVariable String password) {
        Staff user = staffRepository.findByUsername(username);
        String p = user.getPassword();
        System.out.println(username);
        System.out.println(p + " = " + password);
        return p.matches(password);
    }
}
