package com.expense.expence_management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotBlank(message = "Cannot be empty")
     String name;
    @Column(unique =true)
    @NotBlank(message = "Cannot be empty")
    @Email(message = "Invalid mail")
    String email;
    @NotBlank(message = "Cannot be empty")
    @Size(min=8, message="Password must contain minimun 8 characters")
    String password;

    public User(){

    }

    public User(int id,String name,String email,String password){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public int getId(){
    return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
    return email;
    }
    public String getPassword(){
        return password;
    }

    public void setId(int id){
    this.id= id;
    }
    public void setName(String name){
        this.name= name;
    }
    public void setEmail(String email){
    this.email= email;
    }
    public void setPassword(String password){
        this.password= password;
   }
}
