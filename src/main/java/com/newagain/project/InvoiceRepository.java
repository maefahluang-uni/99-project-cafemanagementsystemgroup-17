package com.newagain.project;

import org.springframework.data.repository.CrudRepository;

import com.newagain.project.domain.Invoice;

public interface InvoiceRepository extends CrudRepository <Invoice,Long>{
    
}
