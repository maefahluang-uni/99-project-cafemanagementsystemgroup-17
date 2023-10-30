package com.newagain.project;

public class DishNotEnoughException extends RuntimeException {
    public DishNotEnoughException(Long dishId) {
        super("Dishes not enough now " + dishId);
    }
}
