package com.example.demo.repository;

import com.example.demo.entity.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ResponsibleRepository extends JpaRepository<Responsible,Long> {
    
    Responsible findByResID(Long resID);
}
