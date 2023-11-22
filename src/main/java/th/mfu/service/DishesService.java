package th.mfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.domain.Dishes;
import th.mfu.repository.DishesRepository;

@Service
public class DishesService {

    @Autowired

    private final DishesRepository dishesRepository;

    @Autowired
    public DishesService(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    public void updateDish(
            Long dishId,
            String dishName,
            String dishType,
            String dishPicture,
            Integer dishStock,
            Integer dishPrice,
            String dishStatus) {
        dishesRepository.customUpdate(dishId, dishName, dishType, dishPicture, dishStock, dishPrice, dishStatus);
    }

    public void NumberOfthis(

            Integer dishStock) {
        dishesRepository.NumberOfthis(dishStock);
    }

    public Long getQuantityForDishes(Long dishesId) {
        return dishesRepository.findQuantityById(dishesId);
    }

    // for search
    public List<Dishes> findBykeyword(String keywordString) {
        return dishesRepository.findByKeyword(keywordString);

    }
}