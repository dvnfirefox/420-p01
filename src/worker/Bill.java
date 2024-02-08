package worker;

import java.time.LocalDate;

public class Bill {
    private float amount;
    private LocalDate date;
    public Bill(float amount, LocalDate date){
        this.amount = amount;
        this.date = date;
        System.out.println("date: " + date + " amount: " + amount);
    }
    public void display(){
        System.out.println("date: " + date + " amount: " + amount);
    } // display the bill

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
