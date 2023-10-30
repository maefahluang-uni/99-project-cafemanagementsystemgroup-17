package th.mfu;

import org.springframework.data.repository.CrudRepository;

import  th.mfu.domain.Material;

public interface MaterialRepository extends CrudRepository <Material,Long> {
    
}