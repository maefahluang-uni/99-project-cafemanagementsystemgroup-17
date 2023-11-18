package th.mfu.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.mfu.domain.Dishes;

public interface DishesRepository extends CrudRepository<Dishes, Long> {

        @Modifying
        @Transactional
        @Query("UPDATE Dishes d SET d.dish_name = :dishName, d.dishtype = :dishType, d.dish_picture = :dishPicture, d.dish_stock = :dishStock, d.dish_price = :dishPrice, d.dishStatus = :dishStatus WHERE d.id = :dishId")
        void customUpdate(
                        @Param("dishId") Long dishId,
                        @Param("dishName") String dishName,
                        @Param("dishType") String dishType,
                        @Param("dishPicture") String dishPicture,
                        @Param("dishStock") Integer dishStock,
                        @Param("dishPrice") Integer dishPrice,
                        @Param("dishStatus") String dishStatus);

        @Query("UPDATE Dishes d SET  d.dish_stock = :dishStock")
        void NumberOfthis(@Param("dishStock") Integer dishStock);

        Long findQuantityById(Long dishesId);

        Iterable<Dishes> findByDishtype(String dishtype);

        Iterable<Dishes> findByDishStatus(String dishStatus);

        Iterable<Dishes> findByDishtypeAndDishStatus(String dishtype, String dishStatus);

        // for search
        @Modifying
        @Transactional
        @Query(value = "SELECT * FROM Dishes d WHERE d.dish_name LIKE %:keyword%", nativeQuery = true)
        List<Dishes> findByKeyword(@Param("keyword") String keyword);

        // fixed bug search
        @Query(value = "SELECT * FROM Dishes d WHERE d.dish_name LIKE %:keyword% AND d.dishStatus = :dishStatus", nativeQuery = true)
        List<Dishes> findByKeywordAndDishStatus(@Param("keyword") String keyword,
                        @Param("dishStatus") String dishStatus);
}