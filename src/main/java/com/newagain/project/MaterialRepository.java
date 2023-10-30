package com.newagain.project;

import org.springframework.data.repository.CrudRepository;

import com.newagain.project.domain.Material;

public interface MaterialRepository extends CrudRepository <Material,Long> {
    
}