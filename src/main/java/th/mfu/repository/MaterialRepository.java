package th.mfu.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.mfu.domain.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {
        @Modifying
        @Transactional
        @Query("UPDATE Material m SET m.mat_name = :matName, m.mat_amount = :matAmount, m.matPrice = :matPrice WHERE m.id = :matId")
        void customUpdate(
                        @Param("matId") Long matId,
                        @Param("matName") String matName,
                        @Param("matAmount") Integer matAmount,
                        @Param("matPrice") Integer matPrice);

        @Modifying
        @Transactional
        @Query(value = "SELECT * FROM Material m WHERE m.mat_name LIKE %:keyword%", nativeQuery = true)
        List<Material> findByKeyword(@Param("keyword") String keyword);
}