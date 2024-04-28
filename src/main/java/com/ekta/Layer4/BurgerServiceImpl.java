package com.ekta.Layer4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ekta.Layer2.Burger;
import com.ekta.Layer3.BurgerRepository;

public class BurgerServiceImpl implements BurgerService {

    //autowiring burger repository
    @Autowired
    private BurgerRepository burgerRepo;

    @Override
    public void addBurger(Burger burger) {
        Optional<Burger> opt =burgerRepo.findById(burger.getBurgerId());
        if(opt.isPresent()){
            throw new RuntimeException("Burger is already with id: "+burger.getBurgerId());
        }else{
            burgerRepo.save(burger);
        }
    }

    @Override
    public Burger findBurger(int burgerId) {
        Optional<Burger> opt=burgerRepo.findById(burgerId);
        if(opt.isPresent()){
            // Burger burger=opt.get();
            // return burger;

            return opt.get();
        }else{
            throw new RuntimeException("Burger not found with id: "+burgerId);
        }
    }

    @Override
    public List<Burger> findAllBurger() {
        List<Burger> burgerList=(List<Burger>) burgerRepo.findAll();
        if(burgerList.size()==0){
            throw new RuntimeException("No burger found");
        }else{
            return burgerList;
        }
    }

    @Override
    public void updateBurger(Burger burger) {
        Optional<Burger> opt=burgerRepo.findById(burger.getBurgerId());
        if(opt.isPresent()){
            burgerRepo.save(burger);
        }else{
            throw new RuntimeException("Burger not found with id: "+burger.getBurgerId());
        }
    }

    @Override
    public void deleteBurger(int burgerId) {
        Optional<Burger> opt=burgerRepo.findById(burgerId);
        if(opt.isPresent()){
            burgerRepo.deleteById(burgerId);
        }else{
            throw new RuntimeException("Burger not found with id: "+burgerId);
        }
    }
    
}
