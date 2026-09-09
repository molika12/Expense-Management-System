package com.expense.expence_management.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expence_management.Entity.User;
import com.expense.expence_management.Services.userService;

@RequestMapping("/expence-management/user") 
@RestController 
public class userController {
    private final userService userservice;
    public userController( userService userservice){
           this.userservice=userservice;
    }

    @PostMapping 
    public User addAll(@RequestBody User user){
        return userservice.addAll(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userservice.getAll();
    }

    @GetMapping("/{id}")
    public User getId(@PathVariable int id){
        return userservice.getId(id);
    }

    @PutMapping("/{id}/name")
    public User updateName(@PathVariable int id, @RequestParam String name ){
        return userservice.updateName(id, name);
    }

     @PutMapping("/{id}/email")
    public User updateEmail(@PathVariable int id, @RequestParam String email ){
        return userservice.updateEmail(id, email);
    }

     @PutMapping("/{id}/password")
    public User updatePassword(@PathVariable int id, @RequestParam String password ){
        return userservice.updatePassword(id, password);
    }

     @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userservice.delete(id);
    }
      
}
