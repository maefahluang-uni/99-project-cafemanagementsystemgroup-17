package th.mfu.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.mfu.domain.Dishes;

public interface DishesRepository extends CrudRepository<Dishes, Long> {

        @Modifying
        @Transactional
        @Query("UPDATE Dishes d SET d.dish_name = :dishName, d.dishtype = :dishType, d.dish_picture = :dishPicture, d.dish_stock = :dishStock, d.dish_price = :dishPrice WHERE d.id = :dishId")
        void customUpdate(
                        @Param("dishId") Long dishId,
                        @Param("dishName") String dishName,
                        @Param("dishType") String dishType,
                        @Param("dishPicture") String dishPicture,
                        @Param("dishStock") Integer dishStock,
                        @Param("dishPrice") Integer dishPrice);

        @Query("UPDATE Dishes d SET  d.dish_stock = :dishStock")
        void NumberOfthis(@Param("dishStock") Integer dishStock);

        Long findQuantityById(Long dishesId);

        Iterable<Dishes> findByDishtype(String dishtype);

}