package com.expense.expence_management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Category {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
     @Column(unique =true)
     @NotBlank(message = "Enter your name")
    String name;

public Category(){

}
public Category(int id, String name){
this.id=id;
this.name=name;
}

public int getId(){
    return id;
    }
    public String getName(){
        return name;
    }

    public void setId(int id){
    this.id= id;
    }
    public void setName(String name){
        this.name= name;
    }
}
