package com.newagain.project;

import org.springframework.data.repository.CrudRepository;

import com.newagain.project.domain.InvoiceItem;
public interface InvoiceItemRepository extends CrudRepository <InvoiceItem,Long>{
    
}
