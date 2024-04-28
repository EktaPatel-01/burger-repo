package com.ekta.Layer2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//in place of these four annotation we can use only @Data annotation
public class Burger {

    //pojo-all fields are private
    //    -default /param constructor
    //    -getters and setters

    @Id
    @Column(name = "burgerId")
    private int burgerId;
    @Column(name = "burgerPrice")
    private int price;
    @Column(name ="burgerName" )
    private String name;
    
}
