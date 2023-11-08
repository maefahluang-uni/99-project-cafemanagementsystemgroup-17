package th.mfu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.InvoiceItem;

public interface InvoiceItemRepository extends CrudRepository<InvoiceItem, Long> {
    Iterable<InvoiceItem> findByInvoiceIsNull();

    @Query("SELECT SUM(i.dishAmount) AS totalAmount, i.dishes " +
            "FROM InvoiceItem i " +
            "GROUP BY i.dishes " +
            "ORDER BY totalAmount DESC, i.dishes.dish_name ASC") // Break ties by dish name
    List<Object[]> findTop3Sale();

}
