package com.newagain.project;

import org.springframework.data.repository.CrudRepository;

import com.newagain.project.domain.User;

public interface UserRepository extends CrudRepository <User,Long> {
    
}
