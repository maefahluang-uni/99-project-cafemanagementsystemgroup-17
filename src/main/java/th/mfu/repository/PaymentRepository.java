package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import  th.mfu.domain.Payment;

public interface PaymentRepository extends CrudRepository <Payment,Long>{

    Payment findTopByOrderByIdDesc();
    
}
