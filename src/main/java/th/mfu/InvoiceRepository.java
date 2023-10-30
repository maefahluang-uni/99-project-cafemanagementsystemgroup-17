package th.mfu;

import org.springframework.data.repository.CrudRepository;

import  th.mfu.domain.Invoice;

public interface InvoiceRepository extends CrudRepository <Invoice,Long>{
    
}
