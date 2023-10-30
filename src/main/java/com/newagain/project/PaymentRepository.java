package com.newagain.project;

import org.springframework.data.repository.CrudRepository;

import com.newagain.project.domain.Payment;

public interface PaymentRepository extends CrudRepository <Payment,Long>{
    
}
