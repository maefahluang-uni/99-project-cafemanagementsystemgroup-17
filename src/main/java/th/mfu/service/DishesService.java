package th.mfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Integer dishPrice) {
        dishesRepository.customUpdate(dishId, dishName, dishType, dishPicture, dishStock, dishPrice);
    }

    public void NumberOfthis(

            Integer dishStock) {
        dishesRepository.NumberOfthis(dishStock);
    }

    
    public Long getQuantityForDishes(Long dishesId) {
        return dishesRepository.findQuantityById(dishesId);
    }



}