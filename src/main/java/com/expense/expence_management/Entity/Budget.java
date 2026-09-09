package com.expense.expence_management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
public class Budget {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Positive(message = "The amount should be valid")
    double amount;
    @NotEmpty(message = "Enter the month")
    String month;
    @Positive(message = "The year should be above 0" )
      @Min(value = 2020, message = "Invalid year")
    int year;
    @ManyToOne
     @JoinColumn(name="user_id")
    private User user_id;

    public Budget(){

    }
    public Budget(int id, double amount,String month,int year,User user_id){
        this.id=id;
        this.amount=amount;
        this.month=month;
        this.year=year;
        this.user_id=user_id;
    }

    public int getId(){
        return id;
    }
    public double getAmount(){
        return amount;
    }
    public String getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public User getUser_id(){
        return user_id;
    }

     public void setId(int id){
        this.id=id;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
    public void setMonth(String month){
        this.month=month;
    }
    public void setYear(int year){
        this.year=year;
    }
    public void setUser_id(User user_id){
        this.user_id=user_id;
    }
}
