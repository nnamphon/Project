package com.example.demo.repository;

import com.example.demo.entity.Mold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoldRepository extends JpaRepository<Mold,Long> {
    
    Mold findByMoldID(Long moldID);
}
