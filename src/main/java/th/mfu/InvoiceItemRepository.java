package th.mfu;

import org.springframework.data.repository.CrudRepository;


import  th.mfu.domain.InvoiceItem;
public interface InvoiceItemRepository extends CrudRepository <InvoiceItem,Long>{
    Iterable<InvoiceItem> findByInvoiceIsNull();
}
