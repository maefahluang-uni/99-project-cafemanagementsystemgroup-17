package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import  th.mfu.domain.Invoice;

public interface InvoiceRepository extends CrudRepository <Invoice,Long>{

    Invoice findTopByOrderByIdDesc();
    
}
