package com.ekta.Layer4;

import java.util.List;

import com.ekta.Layer2.Burger;

public interface BurgerService {
    //create
    void addBurger(Burger burger);
    
    //read
    Burger findBurger(int burgerId);

    //readAll
    List<Burger> findAllBurger();

    //update
    void updateBurger(Burger burger);

    //delete
    void deleteBurger(int burgerId);
}
