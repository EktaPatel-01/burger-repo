package com.ekta.Layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekta.Layer2.Burger;
import com.ekta.Layer4.BurgerService;

@RestController
@RequestMapping("/McD")
@CrossOrigin("http://localhost:4200") // for angular connection to avoid cors error

public class BurgerController {
    @Autowired
    private BurgerService burgerSvc;

    @PostMapping("/add")
    public ResponseEntity addBurger(@RequestBody Burger burger) {
        try {
            burgerSvc.addBurger(burger);
            return ResponseEntity.status(HttpStatus.OK).body("Burger added Successfully");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findBurger(@PathVariable("id") int burgerId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(burgerSvc.findBurger(burgerId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity findAllBurger() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(burgerSvc.findAllBurger());

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity updateBurger(@RequestBody Burger burger){
        try {
            burgerSvc.updateBurger(burger);
            return ResponseEntity.status(HttpStatus.OK).body("Burger updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBurger(@PathVariable("id") int burgerId){
        try {
            burgerSvc.deleteBurger(burgerId);
            return ResponseEntity.status(HttpStatus.OK).body("burger deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());  
        }
    }
}
