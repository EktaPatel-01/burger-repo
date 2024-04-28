package com.ekta.Layer3;

import org.springframework.data.repository.CrudRepository;

import com.ekta.Layer2.Burger;

public interface BurgerRepository extends CrudRepository<Burger,Integer> {
    
}
